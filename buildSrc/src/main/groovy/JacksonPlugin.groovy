import org.gradle.api.Plugin
import org.gradle.api.Project
import versioning.Deps

class JacksonPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {
            dependencies {
                annotationProcessor(Deps.Javax.JAXB) {
                    because("Annotation Processors require this to be on annotationProcessor classpath")
                }
                annotationProcessor(Deps.Javax.JAXB_RUNTIME) {
                    because("Annotation Processors require this to be on annotationProcessor classpath")
                }
                annotationProcessor(Deps.Javax.ANNOTATION) {
                    because("Annotation Processors require this to be on annotationProcessor classpath")
                }

                /*-------------------------------------------
                |       J A C K S O N  3.0 MIGRATION        |
                ============================================*/
                /**RESTEASY*/ // change to implementation on migration
//                implementation("org.jboss.resteasy:resteasy-jackson2-provider") {
//                    isTransitive = false
//                }
//                implementation(group="org.jboss.resteasy",             name="resteasy-jaxb-provider") {
//                    isTransitive = false
//                }
                /**RESTEASY*/ // change to implementation on migration
                /**JACKSON*/ // change to implementation on migration
                implementation(Deps.Libs.JACKSON_DATABIND)
                //switched to implementation
//                implementation(Deps.Libs.JACKSON_CORE)
                implementation(Deps.Libs.JACKSON_ANNOTATIONS/*, version = "${project.extra["jackson.version"]}"*/)
                //switched to implementation
//                implementation(Deps.Libs.JACKSON_JAXB_ANNOTATIONS)
                implementation(Deps.Libs.JACKSON_JAXRS_JSON_PROVIDER)
//                implementation(Deps.Libs.JACKSON_JAXRS_BASE)
//                implementation(Deps.Libs.JSON_PATCH)
//                implementation(Deps.Libs.JACKSON_COREUTILS)
                implementation(Deps.Libs.JACKSON_JSR310)       //switched to implementation

                implementation(Deps.Libs.JACKSON_JDK8)         //added
                implementation(Deps.Libs.JACKSON_JSON_ORG)     //added
                implementation(Deps.Libs.JACKSON_HPPC)         //added
//                implementation(Deps.Libs.JACKSON_HIBERNATE5) //added
                implementation(Deps.Libs.ZALANDO_PROBLEM)      //added
                implementation(Deps.Libs.ZALANDO_PROBLEM_JACK) //added
                implementation(Deps.Libs.JACKSON_AFTERBURNER)  //added
                /**JACKSON*/
                /*-------------------------------------------
                |       J A C K S O N  3.0 MIGRATION        |
                ============================================*/
                implementation(Deps.Libs.JACKSON_PARAMETER)
                implementation(Deps.Libs.JACKSON_CSV)

                implementation(Deps.Javax.JAXB) {
                    because("Java 9+")
                }
                implementation(Deps.Javax.JAXB_RUNTIME) {
                    because("Java 9+")
                }
                implementation(Deps.Javax.ANNOTATION) {
                    because("Java 9+")
                }
            }
        }
    }
}
