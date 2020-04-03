package com.loyo.myapplication.useAssets

import android.text.TextUtils
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class GroupHandlerTask : DefaultHandler() {
    private lateinit var group: Group
    private lateinit var person: Person
    var groups = ArrayList<Group>()
    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        super.startElement(uri, localName, qName, attributes)
        if (TextUtils.equals("group", qName)) {
            group = Group()
            group.groupName = attributes!!.getValue(0)
            group.pesons = ArrayList()
        } else if (TextUtils.equals("person", qName)) {
            person = Person()
            person.age = attributes!!.getValue(1).toInt()
            person.name = attributes.getValue(0)
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        if (TextUtils.equals("group", qName)) {
            groups.add(group)
        } else if (TextUtils.equals("person", qName)) {
            group.pesons.add(person)
        }
    }
}