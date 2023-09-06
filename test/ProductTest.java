import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product p1, p2;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
        p2 = new Product("000002", "Lembas", "Elven Wayfare Bread", 200.0);
    }

    @Test
    void setID() {
        p1.setID("000003");
        assertEquals("000003", p1.getID());
    }

    @Test
    void setName() {
        p2.setName("Lemdoe");
        assertEquals("Lemdoe", p2.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Short Top Leaf");
        assertEquals("Short Top Leaf", p1.getDescription());
    }

    @Test
    void setCost() {
        p2.setCost(250.0);
        assertEquals(250.0, p2.getCost());
    }
    @Test
    void toCSVDataRecord() {
        assertEquals("000001, Pipeweed, Long Bottom Leaf, 600.0", p1.toCSVDataRecord());
    }
}