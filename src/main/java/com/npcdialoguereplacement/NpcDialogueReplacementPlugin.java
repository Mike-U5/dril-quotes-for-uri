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
		description = "Changes Uri's random quotes to Dril tweets. Plugin by Mike-U5, original idea by /u/bl__________",
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
				if (name != null && (name.getText().equals("Uri") || name.getText().equals("Captain Tock")) && UriQuotes.contains(this.activeDialog)) {
					dialog.setLineHeight(this.getLineHeight(dialog.getText()));
					dialog.setText(DrilQuotes.getRandomQuote());
					this.activeDialog = null;
				}
			}
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
		final int count = StringUtils.countMatches("<br>", text);

		System.out.println("count " + count);
		if (count == 2) {
			return 28;
		} else if (count == 3) {
			return 20;
		}

		return 16;
	}
}
