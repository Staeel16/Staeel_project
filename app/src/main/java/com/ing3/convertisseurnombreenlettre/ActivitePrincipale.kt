package com.ing3.convertisseurnombreenlettre

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitePrincipale : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principale)

        // Liaison avec les éléments de l'interface utilisateur
        val champNombre = findViewById<EditText>(R.id.champNombre)
        val boutonConvertir = findViewById<Button>(R.id.boutonConvertir)
        val resultatFrancais = findViewById<TextView>(R.id.resultatFrancais)
        val resultatAnglais = findViewById<TextView>(R.id.resultatAnglais)

        // Action pour le bouton "Convertir"
        boutonConvertir.setOnClickListener {
            val texteNombre = champNombre.text.toString().trim() // Lecture et nettoyage de la saisie
            val nbConvertirFr = NombreEnLettresFrancais()
            val nbConvertirEn = NombreEnLettresAnglais()

            if (texteNombre.isNotEmpty()) { // Vérification que le champ n'est pas vide
                val nombre = texteNombre.toIntOrNull() // Conversion en entier ou null si non valide

                if (nombre != null) { // Si la conversion réussit
                    // Conversion du nombre en lettres
                    val resultatFr = nbConvertirFr.convertir(nombre)
                    val resultatEn = nbConvertirEn.convertir(nombre)

                    // Mise à jour des TextView avec les résultats
                    resultatFrancais.text = "Résultat en français : $resultatFr"
                    resultatAnglais.text = "Résultat en anglais : $resultatEn"
                } else {
                    // Si la saisie est invalide (par exemple, texte non numérique)
                    resultatFrancais.text = "Erreur : Veuillez entrer un nombre valide."
                    resultatAnglais.text = "Erreur : Veuillez entrer un nombre valide."
                }
            } else {
                // Si le champ est vide
                resultatFrancais.text = "Erreur : Le champ de saisie est vide."
                resultatAnglais.text = "Erreur : Le champ de saisie est vide."
            }
        }
    }
}
