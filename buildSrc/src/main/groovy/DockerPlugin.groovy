import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import com.bmuschko.gradle.docker.tasks.image.DockerPushImage
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import static org.gradle.api.file.DuplicatesStrategy.EXCLUDE

class DockerPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {

            apply(plugin: "com.bmuschko.docker-remote-api")
            apply(plugin: "nu.studer.credentials")

            docker {
                registryCredentials {
                    url      = "registry.example.com"
                    username = project.credentials.GITLAB_ACC
                    password = project.credentials.GITLAB_SECRET
                    email    = "soberich@example.com"
                }
            }

            def copyDockerFiles = tasks.register("copyDockerFiles", Copy) {
                it.description        = "Copy Dockerfile and required data to build directory"
                it.group              = "docker"
                it.duplicatesStrategy = EXCLUDE
                it.from(file("src/main/docker"))
                it.from(file("$buildDir/libs"))
                it.include("*")
                it.exclude("**/*.y*ml")
                it.into(file("$buildDir/docker"))
            }

            def imageNameGitLab = ""/*obscured*/
            //${name.splitToSequence(' ', '-', '.', '_').joinToString(separator = "") { it.substring(0, 1).toLowerCase() }}"
            def tagLatest = "latest"

            tasks.register("buildDocker", DockerBuildImage) {
                it.description = "Package application as Docker image"
                it.group       = "docker"
                it.dependsOn(copyDockerFiles)
                it.inputDir    = file("$buildDir/docker")
                it.tags        = ["$imageNameGitLab:$tagLatest", "$imageNameGitLab" + ":" + "$version".substring(0, version.toString().indexOf("-SNAPSHOT"))]
            }

            tasks.register("pushDocker", DockerPushImage) {
                it.description = "Push application as Docker image"
                it.group       = "docker"
                it.imageName   = imageNameGitLab
                it.tag         = tagLatest
            }
        }
    }
}
