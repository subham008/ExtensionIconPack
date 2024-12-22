package org.quarksutils.iconpack

import androidx.annotation.DrawableRes

 enum class ExtensionIcon (val label: String) {
    HTML("html"),
    JAVASCRIPT("js"),
    CSS("css"),
    JAVA("java"),
    GITHUB("Github"),
    GIT("git"),
    CSHARP("cs"),
    C_PLUS_PLUS("cpp"),
    PROPERTIES("properties"),
    C("c"),
    PHP("php"),
    PYTHON("py"),
    TYPESCRIPT("ts"),
    ZIP("zip"),
    JSON("json"),
    YAML("yaml"),
}

@DrawableRes
 fun getIcon(extensionIcon: ExtensionIcon) :  Int {
    return when (extensionIcon) {
        ExtensionIcon.HTML -> R.drawable.html
        ExtensionIcon.JAVASCRIPT -> R.drawable.javascript
        ExtensionIcon.CSS -> R.drawable.css
        ExtensionIcon.JAVA -> R.drawable.java
        ExtensionIcon.GITHUB -> R.drawable.github
        ExtensionIcon.GIT -> R.drawable.git
        ExtensionIcon.CSHARP -> R.drawable.csharp
        ExtensionIcon.C_PLUS_PLUS -> R.drawable.c_plus_plus
        ExtensionIcon.PROPERTIES -> R.drawable.properties
        ExtensionIcon.C -> R.drawable.c_icon
        ExtensionIcon.PHP -> R.drawable.php
        ExtensionIcon.PYTHON -> R.drawable.python
        ExtensionIcon.TYPESCRIPT -> R.drawable.typescript
        ExtensionIcon.ZIP -> R.drawable.zip
        ExtensionIcon.JSON -> R.drawable.json
        ExtensionIcon.YAML -> R.drawable.yaml
    }
}

@DrawableRes
fun getIcon(filename:String):Int{
    // Extract the extension from the filename
    val extension = filename.substringAfterLast('.', "").lowercase()

    // Map the extension to the corresponding icon
    val extensionIcon = when (extension) {
        "html" -> ExtensionIcon.HTML
        "js" -> ExtensionIcon.JAVASCRIPT
        "css" -> ExtensionIcon.CSS
        "java" -> ExtensionIcon.JAVA
        "github" -> ExtensionIcon.GITHUB
        "git" -> ExtensionIcon.GIT
        "cs" -> ExtensionIcon.CSHARP
        "cpp" -> ExtensionIcon.C_PLUS_PLUS
        "properties" -> ExtensionIcon.PROPERTIES
        "c" -> ExtensionIcon.C
        "php" -> ExtensionIcon.PHP
        "py" -> ExtensionIcon.PYTHON
        "ts" -> ExtensionIcon.TYPESCRIPT
        "zip" -> ExtensionIcon.ZIP
        "json" -> ExtensionIcon.JSON
        "yaml", "yml" -> ExtensionIcon.YAML // Handle both .yaml and .yml
        else -> null // Unknown extension
    }


    // Return the corresponding drawable resource or a default icon
    return if (extensionIcon != null) {
        getIcon(extensionIcon)
    } else {
        R.drawable.file// Replace with your default icon
    }
}