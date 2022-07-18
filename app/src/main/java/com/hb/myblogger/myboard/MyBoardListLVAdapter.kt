package com.hb.myblogger.myboard


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.view.isVisible
import com.hb.myblogger.R
import com.hb.myblogger.board.BoardModel
import com.hb.myblogger.utils.FBAuth

class MyBoardListLVAdapter(val boardList : MutableList<BoardModel>) : BaseAdapter() {

    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if (view == null) {

            view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent, false)

        }


////       삐삐삐삐삐삐
//        val dataModel = dataSnapshot.getValue(BoardModel::class.java)
//
//        val myUid = FBAuth.getUid()
//        val writerUid = dataModel.uid
//
//        if(myUid.equals(writerUid)){
//            binding.blogSettingIcon.isVisible = true
//        }else{
//
//        }
////

        val title = view?.findViewById<TextView>(R.id.titleArea)
        val content = view?.findViewById<TextView>(R.id.contentArea)
        val time = view?.findViewById<TextView>(R.id.timeArea)

        title!!.text = boardList[position].title
        content!!.text = boardList[position].content
        time!!.text = boardList[position].time

        return view!!
    }
}