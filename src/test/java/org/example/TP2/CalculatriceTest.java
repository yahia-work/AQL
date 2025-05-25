package org.example.TP2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        when(calculatrice.additionner(3, 3)).thenReturn(6);

        int resultat = calculatrice.additionner(3, 3);

        assert(resultat == 6);

        verify(calculatrice).additionner(3, 3);
        verifyNoMoreInteractions(calculatrice);
    }
}
