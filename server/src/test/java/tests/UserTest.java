package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokedex;
import com.codeclan.FinalProject.PokemonAutoBattler.models.StatTracker;
import com.codeclan.FinalProject.PokemonAutoBattler.models.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    static Pokedex pokedex;
    static User user1;
    static StatTracker statTracker;

    @BeforeAll
    static void beforeAll() {

        pokedex = new Pokedex(1, true, 20, 5000,1257, 300, 250);
        statTracker = new StatTracker(10, 8, pokedex, 50);
        user1 = new User("roger@rogerland.com", "rogertmalg", "pokemon123", "image", statTracker);
    }

    @Test
    public void canGetEmail() {
        assertEquals("roger@rogerland.com", user1.getEmail());
    }

    @Test
    public void canSetEmail() {
        user1.setEmail("roger_tmo@rogerland.com");
        assertEquals("roger_tmo@rogerland.com", user1.getEmail());
    }

    @Test
    public void canGetUsername() {
        assertEquals("rogertmalg", user1.getUsername());
    }

    @Test
    public void canSetUsername() {
        user1.setUsername("Rogertmalg");
        assertEquals("Rogertmalg", user1.getUsername());
    }

    @Test
    public void canGetPassword() {
        assertEquals("pokemon123", user1.getPassword());
    }

    @Test
    public void canSetPassword() {
        user1.setPassword("123pokemon");
        assertEquals("123pokemon", user1.getPassword());
    }

    @Test
    public void canGetAvatarImage() {
        assertEquals("image", user1.getAvatarImage());
    }

    @Test
    public void canSetAvatarImage() {
        user1.setAvatarImage("new image");
        assertEquals("new image", user1.getAvatarImage() );
    }

    @Test
    public void canGetStatTracker() {
        assertEquals(statTracker, user1.getStatTracker());
    }



}
