package test;

import static org.assertj.core.api.Assertions.*;

import app.Animal;

import org.junit.Test;
// import org.junit.AfterClass;
// import org.junit.BeforeClass;

public class Testes {
    @Test
    public void animal_attributes() {
        Animal a = new Animal();
        a.idade = 10;
        a.estaDormindo = true;
        a.nome = "Rex";

        assertThat(a.idade).isEqualTo(10);
        assertThat(a.estaDormindo).isEqualTo(true);
        assertThat(a.nome).isEqualTo("Rex");
    }
}