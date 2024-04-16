plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
}

android {
    namespace = "com.ibrahimkurt.core.component"

}

dependencies {
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.material3)
}