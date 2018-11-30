import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.language.jvm.tasks.ProcessResources
import org.springframework.boot.gradle.tasks.run.BootRun

class ProfileDevPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {

            apply(plugin: "org.springframework.boot")
            apply(plugin: "com.moowork.node")

            dependencies {
                implementation(group: "org.springframework.boot", name: "spring-boot-devtools") //comes ONLY from Spring
                implementation(group: "com.h2database", name: "h2") //comes ONLY from Spring TODO("really?")
            }

            def profiles = "dev"
            if (hasProperty("tls")) {
                profiles += ",tls"
            }

            war {
                webAppDirName = "src/main/webapp/"
            }

            tasks.withType(BootRun).configureEach {
                it.args = []
            }

            tasks.withType(ProcessResources).configureEach {
                it.filesMatching("**/application.y*ml") {
                    it.filter {
                        it.replace("#project.version#", "$version")
                    }
                    it.filter {
                        it.replace("#spring.profiles.active#", profiles)
                    }
                }
            }

        }
    }
}
