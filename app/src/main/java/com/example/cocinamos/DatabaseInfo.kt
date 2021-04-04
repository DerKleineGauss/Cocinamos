package com.example.cocinamos

import android.provider.BaseColumns

object DatabaseInfo {
    object Recipes {
        const val create_query = ("CREATE TABLE " + RecipesInfo.table_name + "("
                + BaseColumns._ID + " INTEGER PRIMARY KEY,"
                + RecipesInfo.c_name + " TEXT NOT NULL,"
                + RecipesInfo.c_isImage + " INTEGER NOT NULL,"
                + RecipesInfo.c_isLink + " INTEGER NOT NULL,"
                + RecipesInfo.c_recipeText + " TEXT,"
        +")")

        const val drop_query = "DROP TABLE IF EXISTS ${RecipesInfo.table_name}"

        object RecipesInfo: BaseColumns {
            const val table_name = "recipesTable"
            const val c_name = "Name"
            const val c_isImage = "isImage"
            const val c_isLink = "isLink"
            const val c_recipeText = "recipeText"
        }
    }

    object Ingredients {
        const val create_query = ("CREATE TABLE " + IngredientsInfo.table_name + "("
                + BaseColumns._ID + " INTEGER PRIMARY KEY,"
                + IngredientsInfo.recipe + "TEXT NOT NULL"
                + IngredientsInfo.c_name + " TEXT NOT NULL,"
                + IngredientsInfo.c_amount + " TEXT,"
                + "FOREIGN KEY (" + IngredientsInfo.recipe + ") REFERENCES "
                    + Recipes.RecipesInfo.table_name + "(" + Recipes.RecipesInfo.c_name + ")"
                +")")

        const val drop_query = "DROP TABLE IF EXISTS ${IngredientsInfo.table_name}"

        object IngredientsInfo: BaseColumns {
            const val table_name = "recipesTable"
            const val recipe = "recipe"
            const val c_name = "Name"
            const val c_amount = "Amount"
        }
    }
}