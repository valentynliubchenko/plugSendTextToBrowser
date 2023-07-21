package com.checkpugin.twitplugin

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class TwitAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val editor = event.getData(PlatformDataKeys.EDITOR)
        val selectText = editor?.selectionModel?.selectedText.toString()
        //https://www.deepl.com/translator#ru/en/
        println(selectText)
        val encoded = URLEncoder.encode(selectText, StandardCharsets.UTF_8.toString())
        val url = String.format("https://www.deepl.com/translator#ru/en/%s", encoded)
        println(url)

        BrowserUtil.browse(url);
        Messages.showMessageDialog(
            null,
            url,
            "Tweet Action",
            Messages.getInformationIcon()
        )

        println("Действие выполнено!")
    }

    override fun isDumbAware(): Boolean {
        return false
    }

}