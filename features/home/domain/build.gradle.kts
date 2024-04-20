plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)

}

android {
    namespace = "com.ibrahimkurt.features.home.domain"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.pagination)
}