include(":tools")

if (JavaVersion.current() > JavaVersion.VERSION_1_8) {
    include(":plugin-compat")
}
