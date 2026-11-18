package com.vwf.editor

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.WHITE)
            layoutDirection = View.LAYOUT_DIRECTION_LTR
        }

        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutDirection = View.LAYOUT_DIRECTION_LTR
            gravity = Gravity.CENTER_VERTICAL
            setPadding(0, 0, 0, 0)
            setBackgroundColor(Color.rgb(238, 238, 238))
        }

        val labels = listOf(
            "Import\nVideo",
            "Export\nvideo",
            "Delete",
            "Color And\nLight",
            "Tracks",
            "Cut Tool"
        )

        // Buttons use exactly 4/5 of the available row width.
        // The remaining 1/5 is an intentionally empty area on the RIGHT.
        val buttonsArea = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutDirection = View.LAYOUT_DIRECTION_LTR
            setPadding(0, 0, 0, 0)
        }

        labels.forEach { label ->
            val button = Button(this).apply {
                text = label
                isAllCaps = false
                textSize = 11f
                setTextColor(Color.BLACK)
                setTypeface(typeface, Typeface.BOLD)
                gravity = Gravity.CENTER
                minWidth = 0
                minimumWidth = 0
                minHeight = 0
                minimumHeight = 0
                insetLeft = 0
                insetRight = 0
                insetTop = 0
                insetBottom = 0
                setPadding(1, 2, 1, 2)
                backgroundTintList = android.content.res.ColorStateList.valueOf(Color.rgb(250, 250, 250))
            }
            buttonsArea.addView(
                button,
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                    setMargins(0, 0, 0, 0)
                }
            )
        }

        topBar.addView(
            buttonsArea,
            LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 4f)
        )
        topBar.addView(
            Space(this),
            LinearLayout.LayoutParams(0, 1, 1f)
        )

        page.addView(
            topBar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // The rest of the editor is intentionally left empty at this stage.
        setContentView(page)
    }
}
