
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.BasePluginExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getByName

val Project.basePluginExtension: BasePluginExtension
    get() = this.extensions.getByName<BasePluginExtension>("base")

val Project.javaPluginExtension: JavaPluginExtension
    get() = this.extensions.getByName<JavaPluginExtension>("java")

val Project.versionCatalogs: VersionCatalogsExtension
    get() = this.extensions.getByName<VersionCatalogsExtension>("versionCatalogs")

fun Project.extraValue(name: String): String? =
    if (extra.has(name)) {
        extra[name].toString()
    } else {
        null
    }

fun Project.isExtraEnabled(name: String): Boolean =
    project.extraValue(name)?.toBoolean() == true

val pluginIds = mapOf(
    "spotless" to "com.diffplug.spotless",
    "kotlin-dokka" to "org.jetbrains.dokka",
    "nexus-publish" to "io.github.gradle-nexus.publish-plugin",
    "gradle-entrprise" to "com.gradle.enterprise",
    "gradle-publish" to "com.gradle.plugin-publish",
)

/** If set, project version will be set to the value. */
const val EXTRA_GIT_VERSION = "org.jsonschema2dataclass.internal.git-version"

/** If set, gradle plugin will be prepared for a local publication. */
const val EXTRA_LOCAL_PUBLISH = "org.jsonschema2dataclass.internal.local-publish"

/** If set, spotless plugin will be disabled. */
const val EXTRA_SPOTLESS_DISABLE = "org.jsonschema2dataclass.internal.spotless-disable"
