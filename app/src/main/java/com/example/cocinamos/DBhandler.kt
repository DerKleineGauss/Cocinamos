package com.example.cocinamos

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context

class DBHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "EmployeeDatabase"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //creating tables with fields
        db?.execSQL(DatabaseInfo.Recipes.create_query)
        db?.execSQL(DatabaseInfo.Ingredients.create_query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(DatabaseInfo.Recipes.drop_query)
        db.execSQL(DatabaseInfo.Ingredients.drop_query)
        onCreate(db)
    }

    fun addRecipe(recipe: RecipeModelClass, ingredients: Array<IngredientsModelClass>): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseInfo.Recipes.RecipesInfo.c_name, recipe.name)
        contentValues.put(DatabaseInfo.Recipes.RecipesInfo.c_isImage, recipe.isImage)
        contentValues.put(DatabaseInfo.Recipes.RecipesInfo.c_isLink, recipe.isLink)
        contentValues.put(DatabaseInfo.Recipes.RecipesInfo.c_recipeText, recipe.text)

        var success = db.insert(DatabaseInfo.Recipes.RecipesInfo.table_name, null, contentValues)
        try {
            ingredients.forEach {
                if (addRecipeIngredient(it) == -1L) {
                    throw (error("Row for ingredient "+ it.name + " could not be inserted to Ingredients."))
                }
            }
        } catch (e: Exception) {
            success = -1
        }
        db.close()
        return success
    }

    private fun addRecipeIngredient(ingredient: IngredientsModelClass) : Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseInfo.Ingredients.IngredientsInfo.recipe, ingredient.recipeName)
        contentValues.put(DatabaseInfo.Ingredients.IngredientsInfo.c_name, ingredient.name)
        contentValues.put(DatabaseInfo.Ingredients.IngredientsInfo.c_amount, ingredient.amount)

        val success = db.insert(DatabaseInfo.Ingredients.IngredientsInfo.table_name, null, contentValues)
        db.close()
        return success
    }
}