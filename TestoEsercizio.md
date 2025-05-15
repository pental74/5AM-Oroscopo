# Esercizio: Applicazione Oroscopo

Creare un'applicazione Android che raccolga informazioni personali (nome, data di nascita, genere) in una prima Activity e mostri in una seconda Activity l'età dell'utente, uno sfondo colorato in base al genere e **l'immagine** (oppure **solamente il nome**) del segno zodiacale corrispondente.

## Prima Activity (MainActivity):

**Interfaccia utente:**

* Un campo EditText per l'inserimento del nome.  
  * Un DatePicker o un campo EditText con formato data (gg/mm/aaaa) per la data di nascita.  
    * Un RadioGroup con due RadioButton per selezionare il sesso (Maschio/Femmina) oppure uno Spinner.  
    * Un pulsante "**Calcola**" per passare alla seconda Activity (Risultato).

  **Funzionalità:**

    * Validare che tutti i campi siano compilati (nome non vuoto, data valida, sesso selezionato).  
    * Al click sul pulsante, raccogliere i dati e passarli alla seconda Activity tramite **Intent**.

  ## Seconda Activity (Risultato):

  **Interfaccia utente:**

    * Un TextView per mostrare il nome e l'età calcolata.  
    * Uno sfondo colorato (rosa per femmina, azzurro per maschio).  
    * Un ImageView per mostrare l'immagine del segno zodiacale corrispondente alla data di nascita.

  **Funzionalità:**

    * Calcolare l'età dell'utente in base alla data di nascita e alla data corrente.  
    * Impostare lo sfondo del layout (rosa per femmina, azzurro per maschio).  
    * Determinare il segno zodiacale in base alla data di nascita e mostrare l'immagine corrispondente al segno zodiacale. In alternativa indicare semplicemente il segno zodiacale in una EditText

