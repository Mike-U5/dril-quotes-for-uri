package com.npcdialoguereplacement;

import java.util.Arrays;
import java.util.List;

public class UriQuotes {
	private static final List<String> uriQuotes = Arrays.asList(
		"Arrr, 'tis the young lad who helped save my crew from<br>that scoundrel, Ithoi! How be ye this fine day?",
		"A great captain is always ready to change course.",
		"Actions have consequences.",
		"Can I have your teabag?",
		"Can you stand me?",
		"Have you found the key to the secret room?",
		"I am the egg man, are you one of the egg men?",
		"I believe that it is very rainy in Varrock.",
		"I have a story about that.",
		"I heard that the tall man fears only strong winds.",
		"I quite fancy an onion.",
		"In Canifis the men are known for eating much spam.",
		"In the end, only the three-legged will survive.",
		"It is possible to commit no mistakes and still lose.",
		"Loser says what.",
		"My magic carpet is full of eels",
		"Once, I was a poor man, but then I found a party hat.",
		"Quickly! I've got a bee sticking out of my arm!",
		"The slowest of fishermen catch the swiftest of fish.",
		"*sneezes* What?",
		"The sudden appearance of a deaf squirrel is most puzzling, comrade.",
		"There were three goblins in a bar, which one left first?",
		"Up in the north, I hear they keep milk in bags rather than buckets.",
		"Want to see me bend a spoon?",
		"What's cheese?",
		"Would you like to buy a pewter spoon?"
	);

	static public boolean contains(final String text)
	{
		return UriQuotes.uriQuotes.contains(text);
	}
}
