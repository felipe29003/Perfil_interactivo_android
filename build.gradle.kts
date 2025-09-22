// build.gradle.kts (Nivel de Proyecto)

// No apliques plugins aquí. Usa la sintaxis 'alias' para definir los identificadores
// y aplícalos en el build.gradle.kts del módulo 'app'.
// Este archivo puede estar casi vacío con la configuración moderna.

// Antiguamente aquí se ponía:
// plugins {
//     id("com.android.application") version "x.y.z" apply false
//     id("org.jetbrains.kotlin.android") version "x.y.z" apply false
// }
// Ahora es mejor gestionarlo todo desde libs.versions.toml, por lo que este archivo
// puede quedar vacío o solo con la tarea de limpieza.

buildscript {
    // Las dependencias de classpath ahora se gestionan a través de los plugins en el catálogo.
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
