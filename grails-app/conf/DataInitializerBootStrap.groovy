import com.angrygiant.funtastik.pos.domain.Color
import com.angrygiant.funtastik.pos.domain.Department
import com.angrygiant.funtastik.pos.domain.InventoryItem
import com.angrygiant.funtastik.pos.domain.ItemType
import com.angrygiant.funtastik.pos.domain.Manufacturer
import com.angrygiant.funtastik.pos.domain.Size
import com.angrygiant.funtastik.security.Users
import com.angrygiant.funtastik.security.Role
import com.angrygiant.funtastik.security.UserRole

class DataInitializerBootStrap {

    def init = { servletContext ->

        //initialize Color data
        if (Color.list()?.size() == 0) {
            log.warn("No colors found - initializing basic colors")

            new Color(name: "Blue").save(flush: true)
            new Color(name: "Red").save(flush: true)
            new Color(name: "Green").save(flush: true)
            new Color(name: "Yellow").save(flush: true)
            new Color(name: "Purple").save(flush: true)
            new Color(name: "Black").save(flush: true)
            new Color(name: "Brown").save(flush: true)
            new Color(name: "White").save(flush: true)
            new Color(name: "Grey").save(flush: true)
            new Color(name: "Orange").save(flush: true)
            new Color(name: "Pink").save(flush: true)
            new Color(name: "Gold").save(flush: true)
            new Color(name: "Silver").save(flush: true)
            new Color(name: "Clear").save(flush: true)
            new Color(name: "Pink").save(flush: true)

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

        //initialize a gift card item
        if (!Manufacturer.findByName("Funtastik")) {
            log.warn("No existing manufacturer of name 'Funtastik'...creating...")
            new Manufacturer(name: 'Funtastik', phoneNumber: '717-697-6692', webSite: 'http://www.funtastikonline.net', preferredVendor: true).save(flush: true)
        }

        if (!Color.findByName("Not Applicable")) {
            log.warn("No existing color of 'Not Applicable'...creating...")
            new Color(name: 'Not Applicable').save(flush: true)
        }

        if (!ItemType.findByName("Gift Card")) {
            log.warn("No existing item type of 'Gift Card'...creating...")
            new ItemType(name: 'Gift Card', retired: false).save(flush: true)
        }

        if (!InventoryItem.findBySkuCode("GIFTCARD")) {
            log.warn("Creating special 'GIFTCARD' item...")
            InventoryItem item = new InventoryItem()
            item.name = "Gift Card"
            item.description = "Gift Card"
            item.wholesalePrice = 0.0
            item.retailPrice = 0.0
            item.taxable = false
            item.barcoded = false
            item.skuCode = "GIFTCARD"
            item.archived = false
            item.itemType = ItemType.findByName("Gift Card")
            item.manufacturer = Manufacturer.findByName("Funtastik")
            item.color = Color.findByName("Not Applicable")

            item.save(flush: true)
        }

        if (!Size.findByNameAndItemType("N/A", ItemType.findByName("Gift Card"))) {
            log.warn("Creating special size for gift cards")
            new Size(name: "N/A", itemType: ItemType.findByName("Gift Card")).save(flush: true)
        }

        //set up initial roles
        if (Role.list()?.size() == 0) {
            log.warn("Creating initial roles for application")

            new Role(authority: 'ROLE_ADMIN').save(flush: true)
            new Role(authority: 'ROLE_USER').save(flush: true)
        }

        if (Role.list()?.size() > 0 && Users.list()?.size() == 0) {
            def user = new Users(username: "danimal", enabled: true, password: "danimal", accountExpired: false, accountLocked: false, passwordExpired: false)
            user.save(flush: true)

            def regUser = new Users(username: "joe", enabled: true, password: 'user', accountExpired: false, accountLocked: false, passwordExpired: false)
            regUser.save(flush: true)
        }

        def danimal = Users.findByUsername('danimal')
        def adminRole = Role.findByAuthority('ROLE_ADMIN')

        def userRole = UserRole.findByUserAndRole(danimal, adminRole)

        if (danimal && adminRole && !userRole) {
            log.warn("Creating default DANIMAL user...")
            UserRole.create(danimal, adminRole, true)
        }

        //create a second "regular" user
        def regularUser = Users.findByUsername('joe')
        def regularRole = Role.findByAuthority("ROLE_USER")

        def regularUserRole = UserRole.findByUserAndRole(regularUser, regularRole)

        if (regularUser && regularRole && !regularUserRole) {
            log.warn("Creating default REGULAR user...")
            UserRole.create(regularUser, regularRole, true)
        }
    }
    def destroy = {
    }
}
