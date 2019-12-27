package ru.nuclearreactor.forceofworlds

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.models.ViewPage

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewPage.sub {
             setText(it.getText())
             setHrefs(it.getHrefs())
        }
    }

    fun setText(text: String) {
        val textView = findViewById<TextView>(R.id.appTextView)
        textView.setText(text)
    }

    fun setHrefs(hrefs: Array<Href>) {
        val hrefsView = findViewById<LinearLayout>(R.id.appHrefsView)

        hrefsView.removeAllViews()

        for (href in hrefs) {
            hrefsView.addView(createButton(href))
        }
    }

    fun createButton(href: Href): Button {
        val button = Button(this)

        button.setText(href.label)
        button.setEnabled(href.enable)
        button.setOnClickListener({
            ViewPage.set(href.script())
        })

        return button
    }
}
