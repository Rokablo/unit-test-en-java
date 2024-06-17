public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        if (direccion != null && !direccion.isEmpty() && mensaje != null) {
            emailCliente.enviarCorreo(direccion, mensaje);
        }
        // Aquí podrías manejar casos donde la dirección es inválida o el mensaje es nulo, según tu lógica de negocio.
        // En este ejemplo, simplemente no se envía el correo.
    }
}
