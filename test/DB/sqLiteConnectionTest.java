package DB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sqLiteConnectionTest {

    @Test
    void getConnection() {
        sqLiteConnection conn = new sqLiteConnection();
        try {
            System.out.printf("open database %s\n",!conn.getConnection().isClosed() ? "success" : "fail");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}