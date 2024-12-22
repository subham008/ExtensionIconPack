package org.quarksutils.iconpack

import androidx.annotation.DrawableRes

public enum class ExtensionIcon (val label: String) {
    HTML("HTML"),
    JAVASCRIPT("JavaScript"),
    CSS("CSS"),
    JAVA("Java"),
    GITHUB("Github"),
    GIT("Git"),
    CSHARP("C#"),
    C_PLUS_PLUS("C++"),
    PROPERTIES("Properties"),
    C("C"),
    PHP("PHP"),
    PYTHON("Python"),
    TYPESCRIPT("Typescript"),
    ZIP("Zip"),
    JSON("JSON"),
    YAML("YAML"),
}

@DrawableRes
public fun getIcon(extensionIcon: ExtensionIcon) :  Int {
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