import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.plugins.ide.eclipse.model.SourceFolder
import versioning.Deps

class JpaPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {

            apply(plugin: "idea")
            apply(plugin: "eclipse")
            apply(plugin: "java")
            apply(plugin: "io.ebean")

            // TODO("https://github.com/gradle/gradle/issues/5448#issuecomment-390190509")
            def paths            = [ "generated", "$buildDir/classes/java/main" ]
            def files            = files(paths.toArray())
            idea {
                module {
                    sourceDirs          += files
                    generatedSourceDirs += files
                }
            }

            eclipse {
                classpath {
                    file.whenMerged { cp ->
                        cp.entries.add(new SourceFolder(paths[0], null))
                    }
                }
            }

            configurations {
                apt
            }

            ebean {
                debugLevel       = 2
                queryBeans       = true
                generatorVersion = Deps.Versions.EBEAN_QUERY_GEN
            }

            test {
                testLogging.showStandardStreams = true
            }

            dependencies {
                apt(Deps.Libs.EBEAN_ANNOTATIONS)
                annotationProcessor(Deps.Libs.EBEAN_QUERY_GEN)
                annotationProcessor(Deps.Libs.EBEAN_ANNOTATIONS)
                annotationProcessor(Deps.Javax.JAXB) {
                    because("MetaModel and some other components require this to be on annotationProcessor classpath")
                }
                annotationProcessor(Deps.Javax.JAXB_RUNTIME) {
                    because("BeanValidation annotations on QueryBeans source classes require this to be on annotationProcessor classpath")
                }
                annotationProcessor(Deps.Javax.ANNOTATION) {
                    because("Annotation Processors require this to be on annotationProcessor classpath")
                }
                annotationProcessor(Deps.Libs.VALIDATOR_AP)

                implementation(Deps.Javax.JAXB) {
                    because("Java 9+")
                }
                implementation(Deps.Javax.JAXB_RUNTIME) {
                    because("Java 9+")
                }
                implementation(Deps.Javax.ANNOTATION) {
                    because("Java 9+")
                }
                implementation(Deps.Libs.VALIDATOR)
                implementation(Deps.Libs.EBEAN)
                implementation(Deps.Libs.EBEAN_QUERY)
                implementation(Deps.Libs.EBEAN_ANNOTATIONS)

                testImplementation(Deps.Libs.EBEAN_TEST)
            }
        }
    }
}
