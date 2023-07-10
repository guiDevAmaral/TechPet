# TechPet :dog:

## Apresentação do projeto
**_A TechPet é um projeto de estudo, e foi desenvolvido para quem tem uma creche pet.
As funcionalidades do sistema são voltadas para a administração da creche.
Com ele você pode cadastrar clientes e seus pets, também pode hospedar um pet. O sistema também conta com um sistema de login para segurança de dados. 
Todo sistema é desenvolvido em java e integrado com o banco de dados MySQL com persistência de dados (JPA)._**


# Janelas/Funcionalidades e Códigos
## Tela de Login
![Captura de tela 2023-07-10 104157](https://github.com/guiDevAmaral/TechPet/assets/102475575/e1cf4ead-ab86-4334-b03b-b0ca8c48f32b)

A tela de login foi desenvolvida utilizando a biblioteca swing. E tem como função fazer a validação do usuário e senha que estão salvos no banco de dados.
A função do botão entrar será validar oque foi digitado na área de **Login** e **Senha** com base do que se tem no banco de dados.

### Código
Método botão entrar        
                   
     private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
     Usuario usuario ;
  
      String login = txtLogin.getText();
      String senha = txtSenha.getText();
      
  
      UsuarioDAO uDAO = new UsuarioDAO();
  
      usuario = uDAO.validateUser(login, senha);
  
      if (usuario == null) {
          JOptionPane.showMessageDialog(null, "Login ou senha inválido tente novamente.");
      } else {
          
          
          JOptionPane.showMessageDialog(null, "Bem-vindo "+usuario.getNome()+" !");
          
          dispose();
          TelaOpcoes to = new TelaOpcoes();
          to.setVisible(true);
      }
  
  
     } 

Método de Validação do usuário   

        public Usuario validateUser(String login, String password) {
        
        EntityManager em = JPAUtil.getEntityManager();
        
        
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
        query.setParameter("login", login);
        try {
            Usuario user = query.getSingleResult();
            
            if (user.getSenha().equals(password)) {
                return user;
            }
        } catch (NoResultException e) {
            
        }
        return null; 
    }
 
