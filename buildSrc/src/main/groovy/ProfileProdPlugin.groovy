import com.gorylenko.GenerateGitPropertiesTask
import com.gorylenko.GitPropertiesPluginExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.language.jvm.tasks.ProcessResources
import org.springframework.boot.gradle.tasks.run.BootRun


class ProfileProdPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {

            apply(plugin: "org.springframework.boot")
            apply(plugin: "com.gorylenko.gradle-git-properties")
            apply(plugin: "com.moowork.node")

            dependencies {
                implementation(group: 'org.postgresql', name: 'postgresql')
                testImplementation(group: "com.h2database", name: "h2")
            }

            def profiles = "prod"
            war {
                webAppDirName = "build/www/"
            }

            gitProperties {
                keys = ["git.branch", "git.commit.id.abbrev", "git.commit.id.describe"]
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
                it.filesMatching("**/bootstrap.y*ml") {
                    it.filter {
                        it.replace("#spring.profiles.active#", profiles)
                    }
                }
            }

            tasks.withType(GenerateGitPropertiesTask).configureEach {
                it.onlyIf { GenerateGitPropertiesTask task ->
                    ! task.source.isEmpty()
                }
            }

        }
    }
}
