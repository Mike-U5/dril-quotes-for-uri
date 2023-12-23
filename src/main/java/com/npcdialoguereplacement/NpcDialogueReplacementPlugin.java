package com.npcdialoguereplacement;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@PluginDescriptor(
		name = "Uri Dialogue to Dril tweets",
		tags = {"dril", "twitter", "tweet", "tweets", "uri", "wint", "clues", "x", "dialogue"}
)
public class NpcDialogueReplacementPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;
	private String activeDialog = null;
	private boolean dialogueOpened = false;

	@Subscribe
	public void onBeforeRender(final BeforeRender event) {
		if (this.dialogueOpened) {
			final Widget dialog = client.getWidget(ComponentID.DIALOG_NPC_TEXT);

			if (dialog != null && !dialog.getText().equals(this.activeDialog)) {
				this.activeDialog = dialog.getText();
				final Widget name = client.getWidget(ComponentID.DIALOG_NPC_NAME);

				if (name != null && name.getText().equals("Uri") && UriQuotes.contains(this.activeDialog)) {
					final String drilQuote = DrilQuotes.getRandomQuote();
					dialog.setLineHeight(this.getLineHeight(drilQuote));
					dialog.setText(drilQuote);
					this.activeDialog = null;
				}
			}

			this.dialogueOpened = false;
		}
	}

	@Subscribe
	public void onWidgetLoaded(final WidgetLoaded event) {
		if (event.getGroupId() == 231) {
			this.dialogueOpened = true;
		}
	}

	private int getLineHeight(final String text)
	{
		final int count = StringUtils.countMatches(text, "<br>");

		if (count == 1) {
			return 28;
		} else if (count == 2) {
			return 20;
		} else if (count == 4) {
			return 14; // Cannot happen normally but Dril does not follow mortal rules
		}

		return 16;
	}
}
