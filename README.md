### 📁 **1. Struttura dei dati**

* **Veicolo**

    * Codice identificativo (auto-incrementale)
    * Marca
    * Modello
    * Numero di posti
    * Targa
    * Prezzo al giorno
* **Cliente**

    * Dati anagrafici (non specificati, ma presumibilmente nome, cognome, codice fiscale, ecc.)
* **Noleggio**

    * Cliente
    * Veicolo
    * Data inizio
    * Data fine
    * Data rientro

---

### 🗃️ **File richiesti**

* `VEICOLI.csv`: elenco veicoli iniziali
* `DISPONIBILI.csv`: veicoli disponibili al noleggio (dinamico)
* `CLIENTI.dat` (o simile): archiviazione clienti registrati
* `STORICO_NOLEGGI.csv`: storico dei noleggi conclusi (formato CSV, separatore `;`)
* File serializzato dello **stato dei noleggi attivi** (classe `Noleggio`)

---

### 🛠️ **Funzionalità richieste**

#### **1. Avvio programma**

* Deserializzazione dei noleggi in corso (se presenti)

#### **2. Gestione noleggi**

* **Aggiunta noleggio**:

    * Inserimento cliente (se nuovo, salvataggio)
    * Assegnazione veicolo (presente in `DISPONIBILI`)
    * Salvataggio in lista noleggi attivi
* **Rientro veicolo**:

    * Rimozione noleggio da lista attivi
    * Archiviazione completa in `STORICO_NOLEGGI.csv`
    * Veicolo torna disponibile
* **Calcolo costo totale**:

    * In base a date noleggio e prezzo al giorno

#### **3. Visualizzazioni**

* Tutti i veicoli (ordinati per marca)
* Veicoli disponibili (ordinati per modello)
* Noleggi attivi

#### **4. Gestione veicoli**

* Aggiunta veicolo (auto-incremento ID)
* Eliminazione veicolo

#### **5. Uscita programma**

* Serializzazione dello stato dei noleggi attivi
