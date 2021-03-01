# Official [jsonschema2pojo](https://github.com/joelittlejohn/jsonschema2pojo) Gradle plugin.

This plugin is aiming to take raw JSON or YAML raw files or schemas and convert to Java or Scala POJOs (Plain Old Java Object).

Currently it suppots features like generating using Jackson, GSON and Mocha1 annotations and JSR305.

Please note, that JSR305 is purely supported, and present only if you don't want to use a proper JSON validation for some reasons.

<details>
<summary>How to add a plugin</summary>

```gradle
plugins {
  id "org.jsonschema2dataclass" version "1.2" // Please update version as new versions are out
}
```

Please refer [Gradle Plugins page](https://plugins.gradle.org/plugin/org.jsonschema2dataclass) for further details.

</details>

<details>
<summary>Accepted parameters</summary>

| Parameter                              | Default value                    | Description                                                                                                                                                                                                                                                                   |
|----------------------------------------|----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| annotationStyle                        | AnnotationStyle.JACKSON          | The style of annotations to use in the generated Java types.                                                                                                                                                                                                                  |
| classNamePrefix                        | ''                               | Whether to add a prefix to generated classes.                                                                                                                                                                                                                                 |
| classNameSuffix                        | ''                               | Whether to add a suffix to generated classes.                                                                                                                                                                                                                                 |
| customAnnotator                        | NoopAnnotator.class              | A fully qualified class name, referring to a custom annotator class that implements org.jsonschema2pojo.Annotator and will be used in addition to the one chosen by annotationStyle.                                                                                          |
| customDatePattern                      | -                                | A custom pattern to use when formatting date fields during serialization. Requires support from your JSON binding library.                                                                                                                                                    |
| customDateTimePattern                  | -                                | A custom pattern to use when formatting date-time fields during serialization. Requires support from your JSON binding library.                                                                                                                                               |
| customRuleFactory                      | RuleFactory.class                | A fully qualified class name, referring to an class that extends org.jsonschema2pojo.rules.RuleFactory and will be used to create instances of Rules used for code generation.                                                                                                |
| customTimePattern                      | -                                | A custom pattern to use when formatting time fields during serialization. Requires support from your JSON binding library.                                                                                                                                                    |
| dateTimeType                           | -                                | What type to use instead of string when adding string type fields of format date-time to generated Java types                                                                                                                                                                 |
| dateType                               | -                                | What type to use instead of string when adding string type fields of format date (not date-time) to generated Java types                                                                                                                                                                                                                                                                              |
| fileExtensions                         | [] as String[]                   | -                                                                                                                                                                                                                                                                             |
| fileFilter                             | (no filers)                      | -                                                                                                                                                                                                                                                                             |
| formatDateTimes                        | false                            | -                                                                                                                                                                                                                                                                             |
| formatDates                            | false                            | -                                                                                                                                                                                                                                                                             |
| formatTimes                            | false                            | -                                                                                                                                                                                                                                                                             |
| formatTypeMapping                      | (no default mapping)             | -                                                                                                                                                                                                                                                                             |
| generateBuilders                       | false                            | Whether to generate builder-style methods of the form withXxx(value) (that return this), alongside the standard, void-return setters.                                                                                                                                         |
| includeAdditionalProperties            | true                             | -                                                                                                                                                                                                                                                                             |
| includeAllPropertiesConstructor        | true                             | -                                                                                                                                                                                                                                                                             |
| includeConstructorPropertiesAnnotation | -                                | -                                                                                                                                                                                                                                                                             |
| includeConstructors                    | false                            | -                                                                                                                                                                                                                                                                             |
| includeCopyConstructor                 | -                                | -                                                                                                                                                                                                                                                                             |
| includeDynamicAccessors                | false                            | -                                                                                                                                                                                                                                                                             |
| includeDynamicBuilders                 | false                            | -                                                                                                                                                                                                                                                                             |
| includeDynamicGetters                  | false                            | -                                                                                                                                                                                                                                                                             |
| includeDynamicSetters                  | false                            | -                                                                                                                                                                                                                                                                             |
| includeGetters                         | true                             | -                                                                                                                                                                                                                                                                             |
| includeHashcodeAndEquals               | true                             | -                                                                                                                                                                                                                                                                             |
| includeJsonTypeInfoAnnotation          | false                            | -                                                                                                                                                                                                                                                                             |
| includeJsr303Annotations               | false                            | -                                                                                                                                                                                                                                                                             |
| includeJsr305Annotations               | false                            | -                                                                                                                                                                                                                                                                             |
| includeRequiredPropertiesConstructor   | false                            | -                                                                                                                                                                                                                                                                             |
| includeSetters                         | true                             | -                                                                                                                                                                                                                                                                             |
| includeToString                        | true                             | -                                                                                                                                                                                                                                                                             |
| inclusionLevel                         | InclusionLevel.NON_NULL          | -                                                                                                                                                                                                                                                                             |
| initializeCollections                  | true                             | -                                                                                                                                                                                                                                                                             |
| outputEncoding                         | 'UTF-8'                          | -                                                                                                                                                                                                                                                                             |
| parcelable                             | false                            | -                                                                                                                                                                                                                                                                             |
| propertyWordDelimiters                 | ['-', ' ', '_'] as char[]        | -                                                                                                                                                                                                                                                                             |
| refFragmentPathDelimiters              | "#/."                            | -                                                                                                                                                                                                                                                                             |
| removeOldOutput                        | -                                | -                                                                                                                                                                                                                                                                             |
| serializable                           | false                            | -                                                                                                                                                                                                                                                                             |
| sourceFiles                            | objectFactory.fileCollection()   | -                                                                                                                                                                                                                                                                             |
| sourceSortOrder                        | SourceSortOrder.OS               | -                                                                                                                                                                                                                                                                             |
| sourceType                             | SourceType.JSONSCHEMA            | -                                                                                                                                                                                                                                                                             |
| targetDirectory                        | $buildDir/generated-sources/js2p | -                                                                                                                                                                                                                                                                             |
| targetLanguage                         | -                                | -                                                                                                                                                                                                                                                                             |
| targetPackage                          | ''                               | -                                                                                                                                                                                                                                                                             |
| targetVersion                          | '1.6'                            | -                                                                                                                                                                                                                                                                             |
| timeType                               | null                             | -                                                                                                                                                                                                                                                                             |
| toStringExcludes                       | [] as String[]                   | -                                                                                                                                                                                                                                                                             |
| useBigDecimals                         | false                            | -                                                                                                                                                                                                                                                                             |
| useBigIntegers                         | false                            | -                                                                                                                                                                                                                                                                             |
| useCommonsLang3                        | false                            | -                                                                                                                                                                                                                                                                             |
| useDoubleNumbers                       | true                             | -                                                                                                                                                                                                                                                                             |
| useInnerClassBuilders                  | false                            | If set to true, then the gang of four builder pattern will be used to generate builders on generated classes. Note: This property works in collaboration with the isGenerateBuilders() method. If the isGenerateBuilders() is false, then this property will not do anything. |
| useJodaDates                           | false                            | -                                                                                                                                                                                                                                                                             |
| useJodaLocalDates                      | false                            | -                                                                                                                                                                                                                                                                             |
| useJodaLocalTimes                      | false                            | -                                                                                                                                                                                                                                                                             |
| useLongIntegers                        | false                            | -                                                                                                                                                                                                                                                                             |
| useOptionalForGetters                  | false                            | -                                                                                                                                                                                                                                                                             |
| usePrimitives                          | false                            | -                                                                                                                                                                                                                                                                             |
| useTitleAsClassname                    | false                            | -                                                                                                                                                                                                                                                                             |

</details>
