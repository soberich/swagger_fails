import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.language.jvm.tasks.ProcessResources
import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.bundling.BootWar
import org.springframework.boot.gradle.tasks.run.BootRun


class SpringBootPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {

            apply(plugin: "java")
            apply(plugin: "org.springframework.boot")

            springBoot {
                mainClassName = "com.example.Swagger_fails_App"
                buildInfo()
            }

            tasks.withType(BootWar).configureEach {
                it.manifest { attributes("Automatic-Module-Name": project.group) }
                it.mainClassName = "com.example.Swagger_fails_App"
                it.classifier = "boot"
            }
            tasks.withType(BootJar).configureEach {
                it.manifest { attributes("Automatic-Module-Name": project.group) }
                it.launchScript()
                it.classifier = "boot"
            }
            tasks.withType(Jar).configureEach {
                it.enabled = true
            }
            def cleanResources = tasks.register("cleanResources", Jar) {
                delete("build/resources")
            }
            tasks.withType(JavaCompile).configureEach {
                it.dependsOn(tasks.named(JavaPlugin.PROCESS_RESOURCES_TASK_NAME))
                it.dependsOn(tasks.named("bootBuildInfo"))
            }
            tasks.withType(ProcessResources).configureEach {
                it.dependsOn(cleanResources)
            }
            tasks.named("bootBuildInfo").configure {
                it.mustRunAfter(cleanResources)
            }

            dependencies {
                annotationProcessor(dependencies.platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
                implementation(dependencies.platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
            }
        }
    }
}
