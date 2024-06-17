import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Assert
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    @Test
    public void testNotificarConDireccionVacia() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("", "Mensaje");

        // Assert
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeNulo() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("ejemplo@test.com", null);

        // Assert
        // Aquí podrías implementar la lógica de cómo deseas manejar un mensaje nulo
        // Por ejemplo, si se espera que el método enviarCorreo no sea invocado en caso de mensaje nulo
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConDireccionNula() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar(null, "Mensaje");

        // Assert
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Agregar más tests para casos de esquina y comportamientos inesperados según sea necesario
}
