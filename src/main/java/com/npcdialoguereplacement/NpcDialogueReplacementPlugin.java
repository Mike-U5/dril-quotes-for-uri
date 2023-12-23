package com.npcdialoguereplacement;

import com.google.inject.Provides;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@PluginDescriptor(
		name = "NPC dialog replacer",
		tags = {"uri", "clues", "dialogue"}
)
public class NpcDialogueReplacementPlugin extends Plugin
{
	@Inject
	private NpcDialogueReplacementConfig config;
	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;

	private static final ArrayList<String> customUriQuotes = new ArrayList<String>();
	private String activeDialog = null;
	private boolean dialogueOpened = false;

	@Override
	protected void startUp()
	{
		final String uriDialogPath = config.uriDialogFilePath();

		if (uriDialogPath != null && !uriDialogPath.isEmpty()) {
			try {
				final Scanner scanner = new Scanner(new File(uriDialogPath));

				while (scanner.hasNextLine()) {
					final String line = scanner.nextLine();
					if (!line.isEmpty() && !line.startsWith("#") && !line.startsWith("//")) {
						NpcDialogueReplacementPlugin.customUriQuotes.add(line);
					}
				}

				scanner.close();
			} catch (Exception e) {
				System.out.println("File not found.");
			}
		}
	}

	@Subscribe
	public void onBeforeRender(final BeforeRender event)
	{
		if (this.dialogueOpened) {
			final Widget dialog = client.getWidget(ComponentID.DIALOG_NPC_TEXT);

			if (dialog != null && !dialog.getText().equals(this.activeDialog)) {
				this.activeDialog = dialog.getText();
				final Widget name = client.getWidget(ComponentID.DIALOG_NPC_NAME);

				if (name != null) {
					// Uri
					if ((name.getText().equals("Uri") || name.getText().equals("Captain Tock")) && !this.activeDialog.equals("I do not believe we have any business, Comrade.")) {
						final String customText = customUriQuotes.get(new Random().nextInt(customUriQuotes.size()));
						dialog.setLineHeight(this.getLineHeight(customText));
						dialog.setText(customText);
						this.activeDialog = null;
					}
				}
			}

			this.dialogueOpened = false;
		}
	}

	@Subscribe
	public void onWidgetLoaded(final WidgetLoaded event)
	{
		if (event.getGroupId() == InterfaceID.DIALOG_NPC) {
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
		} else if (count >= 4) {
			return 14;
		}

		return 16;
	}

	@Provides
	NpcDialogueReplacementConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NpcDialogueReplacementConfig.class);
	}
}
