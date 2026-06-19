ENG

Choice of Inheritance Strategy:
After immediately ruling out the TABLE_PER_CLASS strategy due to its clear disadvantages when dealing with relationships in an inheritance hierarchy, I carefully considered the choice between JOINED and SINGLE_TABLE.
In this case, I opted for SINGLE_TABLE because the provided example includes only two subclasses, each with very few specific attributes. As a result, the single table would never become excessively complex, 
effectively eliminating one of the main drawbacks of this approach.
Furthermore, knowing that I would need to work with the data through queries, this strategy allowed me to use simpler and more efficient query operations.
Therefore, SINGLE_TABLE offered the best balance between benefits and drawbacks in this particular scenario.
Although I personally find the JOINED strategy more appealing from both a conceptual and visual standpoint, it was not justified in terms of efficiency for this use case.

Choice of Relationship Type: USER - ITEM
Here I did not need to think much, as the situation clearly reflected the ManyToMany relationship managed through a custom intermediate table that had already been covered during class.
A user can borrow multiple items. Conversely, an item can be borrowed by multiple users.
The relationship is clearly ManyToMany, and since it was necessary to create and customize the intermediate LOAN class with its own specific attributes, the choice of creating a custom intermediate class rather than using the default one was mandatory.


ITA

Scelta tipo di Strategia di Ereditarietà:
Dopo aver escluso immediatamente la TABLE_PER_CLASS per evidente svantaggio in termini di relazioni quando è presente ereditarietà, ho riflettuto a lungo sulla scelta tra JOINED e SINGLE_TABLE.
In questo caso ho optato per la SINGLE_TABLE poichè l'esempio fornito ha solo due sottoclassi le quali hanno pochissimi attributi specifici. La tabella singola quindi non sarebbe mai venuta troppo complicata,
eliminando in principio uno degli svantaggi peggiori di questa metodologia. Inoltre sapendo di dover lavorare sui dati tramite query, in questa maniera avrei potuto utilizzare metodi più semplici e veloci.
Dunque avrei avuto il massimo dei risultati con il minimo degli svantaggi da parte di questa strategia.
Sebbene io preferisca la JOINED a livello concettuale e visivo, in questo caso non era giustificabile in termini di efficienza.

Scelta tipo di relazione: UTENTE - ELEMENTO
Qui non ho avuto bisogno di riflettere molto, la situazione rispecchiava chiaramente la relazione ManyToMany gestita tramite table intermedia custom che già era stata trattata a lezione.
Un utente può prendere in prestito più elementi. Vice versa, un elemento può essere preso in prestito da più utenti.
La relazione è chiaramente ManyToMany e avendo bisogno di creare e customizzare anche la classe intermedia PRESTITO con i propri attributi specifici, la scelta di creare la classe intermedia custom invece di usare quella di default era obbligata.
