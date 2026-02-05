package vista;

import controlador.ControladorPago;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import vista.VistaMenu;
import controlador.ControladorMenu;
import java.util.ArrayList;
import modelo.ReservaDatos;
import modelo.RutaDAO;

public class VistaPago extends javax.swing.JFrame {
    private VistaMenu vistaMenu; // referencia a la vista original
    private ReservaDatos reserva; // la reserva actual
    private ControladorMenu controladorMenu;
    private RutaDAO rutaDAO = new RutaDAO();
 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaPago.class.getName());

    // Creates new form VistaPago
     
    public VistaPago(VistaMenu vistaMenu, ReservaDatos reserva) {
    initComponents();
    configurarBloque();
    this.vistaMenu = vistaMenu; // ⚡ le pasamos la ventana original
    this.reserva = reserva;
}
    
    // Configurar los bloques de texto
    private void configurarBloque() {
        // Para el bloque del numero de la  tarjeta        
        txtTarjeta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Solo registrar números
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                // Limpieza para obtener contar los digitos
                String texto = txtTarjeta.getText().replace(" ", "");
                // Establecer limite de digitos
                if (texto.length() >= 16) {
                    e.consume();
                    return;
                }
                // Colocar un espacio cada 4 dígitos
                if (texto.length()>0&&texto.length()%4 == 0) {
                    txtTarjeta.setText(txtTarjeta.getText() + " ");
                }
            }
        });
        // Para el bloque de la fecha de expiracion
        txtExpiracion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Solo números
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                // Solo 4 numero por mes y año(MM/YY)
                if (txtExpiracion.getText().replace("/", "").length() >= 4) {
                    e.consume();
                    return;
                }
                // Agregar "/" automáticamente después de ingresar el mes
                if (txtExpiracion.getText().length() == 2) {
                    txtExpiracion.setText(txtExpiracion.getText() + "/");
                }
            }
        });  
        // Para el bloque de cedula
        txtCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Solo acepta numeros
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                // El limite de 10 digitos
                if (txtCedula.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
        // Para el bloque de codigo de seguridad
        txtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Para que solo acepte numeros
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                // Para que solo acepte 3 digitos
                if (txtCodigo.getText().length() >= 3) {
                    e.consume();
                }
            }
        });
    }       
    // Extraer la informacion registradas en los bloques de texto
    public String getNumTarjeta() {
        return txtTarjeta.getText();
    }

    public String getExpiracion() {
        return txtExpiracion.getText();
    }
    
    public String getCedula() {
        return txtCedula.getText();
    }

    public String getCodigo() {
        return txtCodigo.getText();
    }
    
    
    // Para que tengan un listener los botones 
    public void addBtnValidarListener(
            java.awt.event.ActionListener listenControles) {
        btnValidar.addActionListener(listenControles);
    }
    
    public void addBtnRealizarListener(
            java.awt.event.ActionListener listenControles) {
        btnCompra.addActionListener(listenControles);
    }
    // Para dejar en blanco despues de realizar la venta
    public void limpiarCampo() {
        txtCodigo.setText("");
        txtTarjeta.setText("");
        txtCedula.setText("");
        txtExpiracion.setText("");
    }
    
    
    public void setControlador(ControladorPago c) {
    addBtnValidarListener(c);
    addBtnRealizarListener(c);
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        panelMetodoPago = new javax.swing.JPanel();
        TabMetodo = new javax.swing.JTabbedPane();
        PanelTarjeta = new javax.swing.JPanel();
        lblTarjeta = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        lblExpiracion = new javax.swing.JLabel();
        txtExpiracion = new javax.swing.JTextField();
        lblSeguridad = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnValidar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        btnCompra = new javax.swing.JButton();
        TabResumen = new javax.swing.JTabbedPane();
        panelResumen = new javax.swing.JPanel();
        lblDestino = new javax.swing.JLabel();
        lblDestino1 = new javax.swing.JLabel();
        lblDestino2 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        txtRegreso = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblPrecio = new javax.swing.JLabel();
        lblImpuesto = new javax.swing.JLabel();
        txtPrecioBoleto = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        lblPago = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        lblDestino3 = new javax.swing.JLabel();
        txtIda = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 8, 78));

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        panelTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblTitulo.setFont(new java.awt.Font("Perpetua Titling MT", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 208, 0));
        lblTitulo.setText("Aerolíneas FIS");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(866, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRegresar.setBackground(new java.awt.Color(255, 208, 0));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnRegresar.setText("Regresar al Inicio");
        btnRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        panelMetodoPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        TabMetodo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        lblTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblTarjeta.setForeground(new java.awt.Color(8, 8, 78));
        lblTarjeta.setText("Número de tarjeta");

        txtTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtTarjeta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblExpiracion.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblExpiracion.setForeground(new java.awt.Color(8, 8, 78));
        lblExpiracion.setText("Fecha de expiración");

        txtExpiracion.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtExpiracion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblSeguridad.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblSeguridad.setForeground(new java.awt.Color(8, 8, 78));
        lblSeguridad.setText("Código de seguridad");

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnValidar.setBackground(new java.awt.Color(255, 208, 0));
        btnValidar.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnValidar.setText("Validar Tarjeta");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtCedula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblCedula.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(8, 8, 78));
        lblCedula.setText("Número de Cédula");

        javax.swing.GroupLayout PanelTarjetaLayout = new javax.swing.GroupLayout(PanelTarjeta);
        PanelTarjeta.setLayout(PanelTarjetaLayout);
        PanelTarjetaLayout.setHorizontalGroup(
            PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTarjetaLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTarjetaLayout.createSequentialGroup()
                        .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTarjetaLayout.createSequentialGroup()
                        .addComponent(txtExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addComponent(lblSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTarjetaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnValidar)
                .addGap(37, 37, 37))
        );
        PanelTarjetaLayout.setVerticalGroup(
            PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTarjetaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(PanelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        TabMetodo.addTab("Pago con Tarjeta", PanelTarjeta);

        javax.swing.GroupLayout panelMetodoPagoLayout = new javax.swing.GroupLayout(panelMetodoPago);
        panelMetodoPago.setLayout(panelMetodoPagoLayout);
        panelMetodoPagoLayout.setHorizontalGroup(
            panelMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMetodoPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabMetodo)
                .addContainerGap())
        );
        panelMetodoPagoLayout.setVerticalGroup(
            panelMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMetodoPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCompra.setBackground(new java.awt.Color(255, 208, 0));
        btnCompra.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnCompra.setText("Realizar Compra");
        btnCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        TabResumen.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        lblDestino.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblDestino.setForeground(new java.awt.Color(8, 8, 78));
        lblDestino.setText("País de Salida");

        lblDestino1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblDestino1.setForeground(new java.awt.Color(8, 8, 78));
        lblDestino1.setText("Fecha de Regreso");

        lblDestino2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblDestino2.setForeground(new java.awt.Color(8, 8, 78));
        lblDestino2.setText("Fecha de Ida");

        txtSalida.setEditable(false);
        txtSalida.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtSalida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtRegreso.setEditable(false);
        txtRegreso.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtRegreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jSeparator1.setMinimumSize(new java.awt.Dimension(60, 20));

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(8, 8, 78));
        lblPrecio.setText("Precio de boleto");

        lblImpuesto.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblImpuesto.setForeground(new java.awt.Color(8, 8, 78));
        lblImpuesto.setText("Impuestos");

        txtPrecioBoleto.setEditable(false);
        txtPrecioBoleto.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtPrecioBoleto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtImpuesto.setEditable(false);
        txtImpuesto.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtImpuesto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblPago.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblPago.setForeground(new java.awt.Color(8, 8, 78));
        lblPago.setText("Total a Pagar");
        lblPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtPago.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPago.setEnabled(false);

        lblDestino3.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblDestino3.setForeground(new java.awt.Color(8, 8, 78));
        lblDestino3.setText("País de Destino");

        txtIda.setEditable(false);
        txtIda.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtIda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtDestino.setEditable(false);
        txtDestino.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        txtDestino.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout panelResumenLayout = new javax.swing.GroupLayout(panelResumen);
        panelResumen.setLayout(panelResumenLayout);
        panelResumenLayout.setHorizontalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblDestino3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblDestino1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblDestino2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(169, 169, 169)
                .addComponent(lblPago, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelResumenLayout.setVerticalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDestino2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDestino3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        TabResumen.addTab("Resumen de la Compra", panelResumen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(951, 951, 951)
                                .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TabResumen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelMetodoPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panelMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(TabResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
    vistaMenu.setVisible(true);

    // Recargar listas de ciudades desde RutaDAO
    ArrayList<String> ciudadesOrigen = rutaDAO.obtenerListaOrigenes();
    ArrayList<String> ciudadesDestino = rutaDAO.obtenerListaDestinos();
    vistaMenu.cargarCiudadesEnCombo(ciudadesOrigen);
    vistaMenu.cargarCiudadesEnCombo2(ciudadesDestino);

    // Cerrar la vistaPago actual
    this.dispose();

    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnValidarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTarjeta;
    private javax.swing.JTabbedPane TabMetodo;
    private javax.swing.JTabbedPane TabResumen;
    public javax.swing.JButton btnCompra;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnValidar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDestino1;
    private javax.swing.JLabel lblDestino2;
    private javax.swing.JLabel lblDestino3;
    private javax.swing.JLabel lblExpiracion;
    private javax.swing.JLabel lblImpuesto;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSeguridad;
    private javax.swing.JLabel lblTarjeta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelMetodoPago;
    private javax.swing.JPanel panelResumen;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtExpiracion;
    private javax.swing.JTextField txtIda;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPrecioBoleto;
    private javax.swing.JTextField txtRegreso;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
