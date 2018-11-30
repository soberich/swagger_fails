import com.github.benmanes.gradle.versions.reporter.result.Result
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.vanniktech.dependency.graph.generator.DependencyGraphGeneratorExtension.Generator
import groovy.xml.MarkupBuilder
import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.attribute.Style
import guru.nidi.graphviz.model.MutableNode
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ComponentSelection
import org.gradle.api.artifacts.ComponentSelectionRules
import org.gradle.api.artifacts.ResolvedDependency

class DependenciesPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.with {
            apply(plugin: "com.vanniktech.dependency.graph.generator")
            apply(plugin: "com.github.ben-manes.versions")

            def springGenerator = new Generator(
                "spring", // Suffix for our Gradle task.
                { ResolvedDependency dependency -> dependency.getModuleGroup().startsWith("org.springframework") }, // Only want Spring.
                { true }, // Include transitive dependencies.
                { MutableNode node, ResolvedDependency dependency -> node.add(Style.FILLED, Color.rgb("#6CB23F")) }, // Give them some color.
            )

            dependencyGraphGenerator {
                generators = [ Generator.ALL, springGenerator ]
            }

            tasks.withType(DependencyUpdatesTask).configureEach {
                it.group = "reporting"
                it.resolutionStrategy {
                    it.componentSelection { ComponentSelectionRules rules ->
                        rules.all { ComponentSelection selection ->
                            boolean rejected = false
                            if (rejected) {
                                selection.reject('We want all candidates -> none rejected')
                            }
                        }
                    }
                }
                it.outputFormatter = { Result result ->
                    def updatable = result.outdated.dependencies
                    if (!updatable.isEmpty()) {
                        def writer = new StringWriter()
                        def html = new MarkupBuilder(writer)

                        html.html {
                            body {
                                table {
                                    thead {
                                        tr {
                                            td("Group")
                                            td("Module")
                                            td("Current version")
                                            td("Latest version")
                                        }
                                    }
                                    tbody {
                                        updatable.each { dependency->
                                            tr {
                                                td(dependency.group)
                                                td(dependency.name)
                                                td(dependency.version)
                                                td(dependency.available.release ?: dependency.available.milestone)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        new File("${project.buildDir}/dependencyUpdates").mkdirs()
                        def file = new File("${project.buildDir}/dependencyUpdates/report.html")
                        file.createNewFile()
                        file.write(writer.toString())
                    }
                }
            }
        }

    }
}
