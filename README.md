ENG
Choice of Inheritance Strategy:
After immediately ruling out the TABLE_PER_CLASS strategy due to its clear disadvantages when dealing with relationships in an inheritance hierarchy, I carefully considered the choice between JOINED and SINGLE_TABLE.
In this case, I opted for SINGLE_TABLE because the provided example includes only two subclasses, each with very few specific attributes. As a result, the single table would never become excessively complex, 
effectively eliminating one of the main drawbacks of this approach.
Furthermore, knowing that I would need to work with the data through queries, this strategy allowed me to use simpler and more efficient query operations.
Therefore, SINGLE_TABLE offered the best balance between benefits and drawbacks in this particular scenario.
Although I personally find the JOINED strategy more appealing from both a conceptual and visual standpoint, it was not justified in terms of efficiency for this use case.

ITA
Scelta tipo di Strategia di Ereditarietà:
Dopo aver escluso immediatamente la TABLE_PER_CLASS per evidente svantaggio in termini di relazioni quando è presente ereditarietà, ho riflettuto a lungo sulla scelta tra JOINED e SINGLE_TABLE.
In questo caso ho optato per la SINGLE_TABLE poichè l'esempio fornito ha solo due sottoclassi le quali hanno pochissimi attributi specifici. La tabella singola quindi non sarebbe mai venuta troppo complicata,
eliminando in principio uno degli svantaggi peggiori di questa metodologia. Inoltre sapendo di dover lavorare sui dati tramite query, in questa maniera avrei potuto utilizzare metodi più semplici e veloci.
Dunque avrei avuto il massimo dei risultati con il minimo degli svantaggi da parte di questa strategia.
Sebbene io preferisca la JOINED a livello concettuale e visivo, in questo caso non era giustificabile in termini di efficienza.
