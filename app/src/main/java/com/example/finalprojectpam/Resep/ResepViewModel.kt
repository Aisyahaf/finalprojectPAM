package com.example.finalprojectpam.Resep


import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose

import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

class ResepViewModel(): ViewModel(){

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<Resep>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("resep")

        val subscription = fireStoreRef.addSnapshotListener { value, error ->
            if (error != null) {
                // Handle error
                close(error)
                return@addSnapshotListener
            }

            if (value != null) {
                val dataList = mutableListOf<Resep>()
                for (doc in value.documents) {
                    val resep = doc.toObject(Resep::class.java)
                    if (resep != null) {
                        dataList.add(resep)
                    }
                }
                trySend(dataList)
            }
        }

        // Cancellation callback
        awaitClose {
            subscription.remove()
        }
    }
    // Cancellation callback


    fun saveData(
        resep: Resep,
        context: android.content.Context
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("resep")
            .document(resep.id)

        try{
            fireStoreRef.set(resep)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully Create Data ", Toast.LENGTH_SHORT).show()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun retrieveData(
        id: String,
        context: android.content.Context,
        data: (Resep) -> Unit
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("resep")
            .document(id)

        try{
            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()){
                        val resep = it.toObject<Resep>()!!
                        data(resep)
                    } else {
                        Toast.makeText(context, "No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteData(
        id: String,
        context: android.content.Context,
        navController: NavController,
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("resep")
            .document(id)

        try{
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Succsesfully delate data", Toast.LENGTH_LONG).show()
                    navController.popBackStack()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}