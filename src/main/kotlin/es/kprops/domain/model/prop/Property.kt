package es.kprops.domain.model.prop

/**
 * @author Alfredo Sanz
 * @time 2022
 */
 class Property {
    var id: Int = 0
        set(value) { field = value  }
    var domain: String = ""
        set(value) { field = value  }
    var key: String = ""
        set(value) { field = value  }
    var value: String = ""
        set(_value) { field = _value  }
    var it_gestionable: Int = 0
        set(value) { field = value  }
    var ds_descripcion_interna: String = ""
        set(value) { field = value  }
    var it_public: Int = 0
        set(value) { field  = value  }
    var flg_front: Int = 0
        set(value) { field = value  }
    var predictivo: Int = 0
        set(value) { field = value  }
    var textarea: Int = 0
        set(value) { field = value  }
    var dsName: String = ""
        get()  { return field }
        set(_value: String) { field = _value  }

    override fun toString(): String {
        return "Property(id=$id, domain='$domain', key='$key', value='$value'," +
                " it_gestionable=$it_gestionable, ds_descripcion_interna='$ds_descripcion_interna', " +
                "it_public=$it_public, flg_front=$flg_front, predictivo=$predictivo, " +
                "textarea=$textarea, dsName=$dsName)"
    }


}
