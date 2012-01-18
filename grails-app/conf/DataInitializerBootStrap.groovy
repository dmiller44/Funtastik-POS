import com.angrygiant.funtastik.pos.domain.Color
import com.angrygiant.funtastik.pos.domain.Department
import com.angrygiant.funtastik.pos.domain.ItemType
import com.angrygiant.funtastik.pos.domain.Size

class DataInitializerBootStrap {

    def init = { servletContext ->

        //initialize Color data
        if (Color.list()?.size() == 0) {
            log.warn("No colors found - initializing basic colors")

            new Color(name: "blue").save(flush: true)
            new Color(name: "red").save(flush: true)
            new Color(name: "green").save(flush: true)
            new Color(name: "yellow").save(flush: true)
            new Color(name: "purple").save(flush: true)
            new Color(name: "black").save(flush: true)
            new Color(name: "brown").save(flush: true)
            new Color(name: "white").save(flush: true)
            new Color(name: "grey").save(flush: true)
            new Color(name: "orange").save(flush: true)
            new Color(name: "pink").save(flush: true)
            new Color(name: "gold").save(flush: true)
            new Color(name: "silver").save(flush: true)
            new Color(name: "clear").save(flush: true)

            log.info("Done adding initial colors")
        }

        //initialize department data
        if (Department.list()?.size() == 0) {
            log.warn("No departments found - initializing basic department list")

            new Department(name: "Dakine Gloves", retired: false).save(flush: true)
            new Department(name: "Snow Softgoods", retired: false).save(flush: true)
            new Department(name: "Snow Hardgoods", retired: false).save(flush: true)
            new Department(name: "Skate Hardgoods", retired: false).save(flush: true)
            new Department(name: "Skate Softgoods", retired: false).save(flush: true)

            log.info("Done adding initial departments")
        }

        //initialize types data
        if (ItemType.list()?.size() == 0) {
            log.warn("No item types found - initializing basic item types list")

            new ItemType(retired: false, name: "Gloves").save(flush: true)
            new ItemType(retired: false, name: "Snowboard").save(flush: true)
            new ItemType(retired: false, name: "Shoe").save(flush: true)
            new ItemType(retired: false, name: "Boot").save(flush: true)
            new ItemType(retired: false, name: "Deck").save(flush: true)

            log.info("Done adding initial types")
        }

        //initialize size data
        if (Size.list()?.size() == 0) {
            log.warn("No sizes found - initializing basic size lists")

            ItemType gloveType = ItemType.findByName("Gloves")

            if (gloveType) {
                new Size(name: "XS", itemType: gloveType).save(flush: true)
                new Size(name: "S", itemType: gloveType).save(flush: true)
                new Size(name: "M", itemType: gloveType).save(flush: true)
                new Size(name: "L", itemType: gloveType).save(flush: true)
                new Size(name: "XL", itemType: gloveType).save(flush: true)
            }

            log.info("Done adding initial sizes")
        }
    }
    def destroy = {
    }
}
