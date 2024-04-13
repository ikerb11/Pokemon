package com.example.ejemplogeolocalicacion

import android.R.attr.name
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ejemplogeolocalicacion.Entidades.Pokemon


class PokemonAdapter() : BaseAdapter(), Parcelable {
    private var productos: List<Pokemon>? = null;
    var context: Context? = null

    constructor(parcel: Parcel) : this() {

    }

    constructor(c: Context?, arrayList: ArrayList<Pokemon>?) : this() {
        context = c
        productos = arrayList
    }
    override fun getCount(): Int {
        return productos!!.size
    }

    override fun getItem(position: Int): Any {
        return productos!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var  view = convertView
        if (convertView == null) {
            val inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.activity_pokemon_layout, null)
        }
        val nombre = view!!.findViewById<TextView>(R.id.nombre)
        nombre.setText(productos!![position].nombre)
        val tipo = view!!.findViewById<TextView>(R.id.tipo)
        tipo.setText(productos!![position].tipo)
        val peso = view!!.findViewById<TextView>(R.id.peso)
        peso.setText(productos!![position].peso.toString())
        val altura = view!!.findViewById<TextView>(R.id.altura)
        altura.setText(productos!![position].altura.toString())
        val longitud = view!!.findViewById<TextView>(R.id.longitud)
        longitud.setText(productos!![position].longitud.toString())
        val habilidades = view!!.findViewById<TextView>(R.id.habilidades)
        habilidades.setText(productos!![position].habilidades)
        val imagen = view!!.findViewById<ImageView>(R.id.imageView)
        val img = "res/drawable/" + name + ".png" // create the file name


        //val mDrawableName = "logo_default"
        //val resID = res.getIdentifier(mDrawableName, "drawable", getPackageName())
        //imagen.setImageDrawable(resID);

        return view!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonAdapter> {
        override fun createFromParcel(parcel: Parcel): PokemonAdapter {
            return PokemonAdapter(parcel)
        }

        override fun newArray(size: Int): Array<PokemonAdapter?> {
            return arrayOfNulls(size)
        }
    }
}