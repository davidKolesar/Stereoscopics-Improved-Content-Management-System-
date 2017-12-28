window.onload = loadQuoteArray();


function loadQuoteArray() {
	//Storing quotes in array
	var quoteVault = [
		'"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vulputate neque eget elit finibus, eget molestie." - Mauris Interdum', 
		'"Secut erat en principio et nunc et semper et en sacula." - Dolorem',
		'"Curabitur congue tellus non tristique malesuada." - Altare',
		'"Suspendisse pulvinar accumsan nisi, et pretium justo efficitur nec." - Suspendisse', 
		'"Pulvinar, ipsum at faucibus accumsan, enim tellus suscipit nisi." - Introibo',
		'"Sit amet vehicula erat lacus in erat. Mauris tellus lacus." - Satanas',
		'"Consectetur ut dictum ac, luctus sed ipsum. Suspendisse ac libero tellus. Etiam pharetra tristique erat" - Nostre', 
		'"A cursus tortor sagittis" - Nomine ',
		'"A Duis pharetra tincidunt vestibulum. Mauris dictum tortor mauris" - Convallis',
		'"Semper magna consequat et." - Aenean '
		 ]
	//Selecting random quote
	var randomQuote = quoteVault[Math.floor(Math.random() * quoteVault.length)];
	//Outputting quote to webpage
	document.getElementById("quoteOutputSpace").innerHTML = randomQuote;
}

