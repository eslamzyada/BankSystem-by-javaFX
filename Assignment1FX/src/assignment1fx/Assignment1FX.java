/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1fx;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.logging.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author MS
 */

public class Assignment1FX extends Application{
    private static final LinkedList<User> users = new LinkedList<>();
    private static final LinkedList<Account> accounts = new LinkedList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    private String firstName, lastName, eMail, phone, password, confirm, country, gender, streetAddress, region, postal, city, id, passwordVerification;
    private String[] languages;
    private LocalDate dateOfBirth;
    private Address address;
    private AccountType accountType;
    private String accountNumber;

    @Override
    public void start(Stage stage) throws Exception {
        
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        
        // Create welcome label
        Label welcome = createLabel("Welcome to our System!", "Times new Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 22);
        welcome.setTextFill(Color.DARKCYAN);
        GridPane.setHalignment(welcome, HPos.CENTER);

        // Create rectangle and buttons
        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setFill(Color.DARKCYAN);
        rectangle.setStroke(Color.BLACK);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);

        Button signUp = createButton("Sign Up", "Times new Roman", 16, 100, 40, "white", "black", "black", "white");
        Button logIn = createButton("Sign In", "Times new Roman", 16, 100, 40, "white", "black", "black", "white");

        signUp.setOnAction(e-> regestrationPage(stage));
        logIn.setOnAction(e-> loginPage(stage));
        
        // Create a VBox to hold the buttons
        VBox buttonBox = new VBox(10, signUp, logIn);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Add the rectangle and buttonBox to a StackPane
        StackPane stackPane = new StackPane(rectangle, buttonBox);
        stackPane.setAlignment(Pos.CENTER);
        
        box.getChildren().addAll(welcome, stackPane);
        
        // Create scene and set it to the stage
        Scene scene = new Scene(box, 400, 400);
        Image icon = new Image("https://worldflags.net/assets/img/flags/palestine-flag.png");
        stage.getIcons().add(icon);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.show();
    }
    
    public void regestrationPage(Stage stage){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setAlignment(Pos.CENTER);
        
        ScrollPane scrollPane = new ScrollPane(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        Scene scene = new Scene(scrollPane, 600, 600);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.setMaximized(true);
        Image icon = new Image("https://worldflags.net/assets/img/flags/palestine-flag.png");
        stage.getIcons().add(icon);
        stage.setTitle("Bank system");
        stage.show();
        
        Label registration = createLabel("Registration", "Times new Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 26);
        registration.setAlignment(Pos.TOP_CENTER);
        registration.setTextFill(Color.DARKCYAN);
        grid.add(registration, 1, 0, 2, 1);
        
        HBox nameBox = new HBox();
        nameBox.setSpacing(10);
        Label nameLabel = createLabel("Name", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        TextField firstNameField = createTextField("Enter your first name", 150);
        TextField lastNameField = createTextField("Enter your last name", 150);
        nameBox.getChildren().addAll(firstNameField, lastNameField);
        grid.add(nameLabel, 0, 1);
        grid.add(nameBox, 1, 1);
        
        Label idLabel = createLabel("ID Number", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        TextField idField = createTextField("ID Number", 300);
        grid.add(idLabel, 0, 2);
        grid.add(idField, 1, 2);
        
        Label dateOfBirthLabel = createLabel("Date Of Birth", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        DatePicker dateOfBirthPicker = new DatePicker();
        dateOfBirthPicker.setPromptText("MM/DD/YY");
        grid.add(dateOfBirthLabel, 0, 3);
        grid.add(dateOfBirthPicker, 1, 3);
        
        Label eMailLabel = createLabel("Email", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        TextField eMailField = createTextField("Enter your Email", 300);
        grid.add(eMailLabel, 0, 4);
        grid.add(eMailField, 1, 4);
        
        Label phoneLabel = createLabel("Phone", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        TextField phoneField = createTextField("Enter your Phone number", 300);
        grid.add(phoneLabel, 0, 5);
        grid.add(phoneField, 1, 5);
        
        Label passwordLabel = createLabel("Password", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setMaxWidth(300);
        grid.add(passwordLabel, 0, 6);
        grid.add(passwordField, 1, 6);
        
        Label confirmLabel = createLabel("Confirm", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        PasswordField confirmField = new PasswordField();
        confirmField.setPromptText("Enter password again");
        confirmField.setMaxWidth(300);
        grid.add(confirmLabel, 0, 7);
        grid.add(confirmField, 1, 7);
        
        Label passwordVerificationLabel = createLabel("Verify password", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        TextField passwordVerificationField = createTextField("What is your mother name?", 300);
        grid.add(passwordVerificationLabel, 0, 8);
        grid.add(passwordVerificationField, 1, 8);
    
        Label countryLabel = createLabel("Country", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        ComboBox<Country> countryComboBox = new ComboBox();
        Country select = new Country("select");
        countryComboBox.setValue(select);
        
        ObservableList<Country> items = countryComboBox.getItems();
        items.add(new Country("Palestine"));
        items.add(new Country("Syria"));
        items.add(new Country("Lebanon"));
        items.add(new Country("Jordan"));
        items.add(new Country("Egypt"));
        items.add(new Country("Libya"));
        items.add(new Country("Tunisia"));
        items.add(new Country("Morocco"));
        items.add(new Country("Algeria"));
        items.add(new Country("Sudan"));
        items.add(new Country("Somalia"));
        items.add(new Country("Djibouti"));
        items.add(new Country("The Comoros Islands"));
        items.add(new Country("Bahrain"));
        items.add(new Country("Iraq"));
        items.add(new Country("Saudi Arabia"));
        items.add(new Country("UAE"));
        items.add(new Country("Kuwait"));
        items.add(new Country("Qatar"));
        items.add(new Country("Oman"));
        items.add(new Country("yemen"));
        items.add(new Country("Mauritania"));
        
        countryComboBox.setMaxWidth(110);
        grid.add(countryLabel, 0, 9);
        grid.add(countryComboBox, 1, 9);
        
        HBox genderHBox = new HBox();
        Label genderLabel = createLabel("Gender", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        RadioButton maleButton = new RadioButton("male");
        RadioButton femaleButton = new RadioButton("female");
        ToggleGroup toggleGroup = new ToggleGroup();
        maleButton.setToggleGroup(toggleGroup);
        maleButton.setFont(Font.font("Times new Roman", 14));
        femaleButton.setToggleGroup(toggleGroup);
        femaleButton.setFont(Font.font("Times new Roman", 14));
        genderHBox.getChildren().addAll(maleButton, femaleButton);
        genderHBox.setSpacing(10);
        grid.add(genderLabel, 0, 10);
        grid.add(genderHBox, 1, 10);
        
        HBox languageHBox = new HBox();
        Label languageLabel = createLabel("Languages", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        CheckBox arabicCheckBox = new CheckBox("Arabic");
        arabicCheckBox.setFont(Font.font("Times new Roman", 14));
        CheckBox englishCheckBox = new CheckBox("English");
        englishCheckBox.setFont(Font.font("Times new Roman", 14));
        CheckBox spanishCheckBox = new CheckBox("Spanish");
        spanishCheckBox.setFont(Font.font("Times new Roman", 14));
        languageHBox.getChildren().addAll( arabicCheckBox, englishCheckBox, spanishCheckBox);
        languageHBox.setSpacing(10);
        grid.add(languageLabel, 0, 11);
        grid.add(languageHBox, 1, 11);
        
        HBox streetAndCity = new HBox();
        streetAndCity.setSpacing(10);
        HBox regionAndPostal = new HBox();
        regionAndPostal.setSpacing(10);
        
        Label addressLabel = createLabel("Address", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        TextField streetAddressField = createTextField("Enter your Street Address", 150);
        TextField cityField = createTextField("your City", 150);
        TextField regionField = createTextField("Region", 150);
        TextField postalField = createTextField("Postal / ZIP code", 150);
        streetAndCity.getChildren().addAll(streetAddressField, cityField);
        regionAndPostal.getChildren().addAll(regionField, postalField);
        
        grid.add(addressLabel, 0, 12);
        grid.add(streetAndCity, 1, 12);
        grid.add(regionAndPostal, 1, 13);
        
        Label accountTypeLabel = createLabel("Account Type", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        ComboBox<AccountType> accountTypeComboBox = new ComboBox();
        accountTypeComboBox.getItems().addAll(AccountType.values());
        accountTypeComboBox.getItems().set(0, AccountType.CHECKING_ACCOUNT);
        grid.add(accountTypeLabel, 0, 14);
        grid.add(accountTypeComboBox, 1, 14);
        
        HBox buttonsBox = new HBox();
        Button register = createButton("Register", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        final Text message = new Text();
        grid.add(message, 1, 16);
        register.setOnAction(e -> {
            firstName = firstNameField.getText();
            lastName = lastNameField.getText();
            id = idField.getText();
            dateOfBirth = dateOfBirthPicker.getValue();
            eMail = eMailField.getText();
            phone = phoneField.getText();
            password = passwordField.getText();
            confirm = confirmField.getText();
            passwordVerification = passwordVerificationField.getText();
            streetAddress = streetAddressField.getText();
            region = regionField.getText();
            postal = postalField.getText();
            city = cityField.getText();
            
            country = "";
            gender = "";
            languages = null;
            if (firstName.isEmpty() || !firstName.matches("^[a-zA-Z]{3,}$")) {
                message.setText("Please enter a valid first name");
                message.setFill(Color.RED);
            }else if (lastName.isEmpty() || !lastName.matches("^[a-zA-Z]{3,}$")) {
                message.setText("Please enter a valid last name");
                message.setFill(Color.RED);
            }else if(id.isEmpty() || !id.matches("^[0-9]{9}$")){
                message.setText("Please enter a valid id number");
                message.setFill(Color.RED);
            } else if (!validateDateOfBirth(dateOfBirth)) {
                message.setText("Please enter your date of birth");
                message.setFill(Color.RED);
            }else if (eMail.isEmpty() || !eMail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                message.setText("Please enter a valid email address");
                message.setFill(Color.RED);
            } else if (phone.isEmpty() || (!phone.matches("^[059]+[0-9]{7}$") && !phone.matches("^[056]+[0-9]{7}$"))) {
                message.setText("Please enter a valid phone number");
                message.setFill(Color.RED);
            } else if (password.isEmpty() || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
                message.setText("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character");
                message.setWrappingWidth(300);
                message.setFill(Color.RED);
            } else if (!password.equals(confirm)) {
                message.setText("Passwords do not match");
                message.setFill(Color.RED);
            } else if (passwordVerification.isEmpty() || !passwordVerification.matches("^[A-Za-z]{3,}$")) {
                message.setText("Please Enter a valid answer!");
                message.setFill(Color.RED);
            } else if (countryComboBox.getSelectionModel().isEmpty()) {
                message.setText("Please select a country");
                message.setFill(Color.RED);
            } else if (!maleButton.isSelected() && !femaleButton.isSelected()) {
                message.setText("Please select a gender");
                message.setFill(Color.RED);
            } else if (!arabicCheckBox.isSelected() && !englishCheckBox.isSelected() && !spanishCheckBox.isSelected()) {
                message.setText("Please select at least one language");
                message.setFill(Color.RED);
            } else if (streetAddress.isEmpty() || Character.isDigit(streetAddress.charAt(0))) {
                message.setText("Please Enter your Street Address");
                message.setFill(Color.RED);
            } else if (region.isEmpty() || Character.isDigit(region.charAt(0))) {
                message.setText("Please Enter your Region");
                message.setFill(Color.RED);
            } else if (postal.isEmpty() || !postal.matches("^[0-9]{7}$")) {
                message.setText("Please Enter your postal / ZIP code");
                message.setFill(Color.RED);
            } else if (city.isEmpty() || Character.isDigit(city.charAt(0))) {
                message.setText("Please Enter your city");
                message.setFill(Color.RED);
            }else if(accountTypeComboBox.getSelectionModel().isEmpty()) {
                message.setText("Please choose an account type");
                message.setFill(Color.RED);
            }else {
                country = countryComboBox.getSelectionModel().getSelectedItem().getCountry();
                gender = maleButton.isSelected() ? "male" : "female";
                accountType = accountTypeComboBox.getSelectionModel().getSelectedItem();
                List<String> selectedLanguages = new ArrayList<>();
                if (arabicCheckBox.isSelected()) {
                    selectedLanguages.add(arabicCheckBox.getText());
                }
                if (englishCheckBox.isSelected()) {
                    selectedLanguages.add(englishCheckBox.getText());
                }
                if (spanishCheckBox.isSelected()) {
                    selectedLanguages.add(spanishCheckBox.getText());
                }
                languages = selectedLanguages.toArray(new String[selectedLanguages.size()]);
                address = new Address(streetAddress, city, region , postal, country);
                User newUser = new User(firstName, lastName, id, dateOfBirth, eMail, phone, password, confirm, passwordVerification, country, gender, languages, address);
                users.add(newUser);
                int index = findUserIndex(users, eMail);
                LocalDate currentDate = LocalDate.now();
                Account newAccount = new Account(accountType, users.get(index), currentDate, null, null, false);
                accounts.add(newAccount);
                message.setText("Registered successfully, Go to Login page");
                message.setFill(Color.GREEN);
            }
        });
        
        Button logIn = createButton("LogIn", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white","black");
        Tooltip tooltip = new Tooltip();
        tooltip.setText("This is a log in button");
        tooltip.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tooltip.setShowDuration(Duration.seconds(5));
        logIn.setTooltip(tooltip);
        logIn.setOnAction(e -> {
            firstNameField.clear();
            lastNameField.clear();
            idField.clear();
            dateOfBirthPicker.setValue(null);
            eMailField.clear();
            phoneField.clear();
            passwordField.clear();
            confirmField.clear();
            passwordVerificationField.clear();
            countryComboBox.setValue(select);
            maleButton.setSelected(false);
            femaleButton.setSelected(false);
            arabicCheckBox.setSelected(false);
            englishCheckBox.setSelected(false);
            spanishCheckBox.setSelected(false);
            streetAddressField.clear();
            regionField.clear();
            postalField.clear();
            cityField.clear();
            message.setText(null);
            loginPage(stage);
        }); 
        
        buttonsBox.getChildren().addAll(register, logIn);
        buttonsBox.setSpacing(10);
        grid.add(buttonsBox, 1, 15);
    }
    private boolean validateDateOfBirth(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        LocalDate minimumAge = currentDate.minusYears(18);
        LocalDate maximumAge = LocalDate.of(1900, Month.JANUARY, 1);

    return dateOfBirth != null && 
           !dateOfBirth.isAfter(minimumAge) && 
           !dateOfBirth.isBefore(maximumAge);
    }
    public void loginPage(Stage stage){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setAlignment(Pos.CENTER);
        grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(5),new BorderWidths(3), new Insets(10))));
        
        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        
        Label registration = createLabel("LogIn", "Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        registration.setAlignment(Pos.TOP_CENTER);
        grid.add(registration, 1, 0, 2, 1);
        
        Label eMailLabel = createLabel("Email", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField eMailField = createTextField("Enter your Email", 300);
        grid.add(eMailLabel, 0, 1);
        grid.add(eMailField, 1, 1);
        
        Label passwordLabel = createLabel("Password", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        
        final Text loginMessage = new Text();
        loginMessage.setFont(Font.font("Times new Roman", 16));
        Button logIn = createButton("LogIn", "Times new Roman", 16, 80, 40, "darkCyan", "white", "white", "black");
        Tooltip loginTooltip = new Tooltip();
        loginTooltip.setText("This is a log in button");
        loginTooltip.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        loginTooltip.setShowDuration(Duration.seconds(5));
        logIn.setTooltip(loginTooltip);
        logIn.setOnAction(e -> {
            String email = eMailField.getText();
            String passwordCheck = passwordField.getText();

            int index = findUserIndex(users, email);
            if(index == -1){
                loginMessage.setText("Can't find this Email!");
                loginMessage.setFill(Color.RED);
            }else{
                if(users.get(index).getPassword().equals(passwordCheck)){
                // If the user was found and the password matches, login was successful
                loginMessage.setText("Logged in successfully!");
                loginMessage.setFill(Color.GREEN);
                // Call startSystem with the correct arguments
                startSystem(stage, index);
                }else{
                    loginMessage.setText("Wrong password, Try again!");
                    loginMessage.setFill(Color.RED);
                    Button forgotPassword = new Button("Forgot password?");
                    forgotPassword.setBackground(null);
                    forgotPassword.setTextFill(Color.RED);
                    forgotPassword.setFont(Font.font("Times new Roman", 16));
                    forgotPassword.setCursor(Cursor.HAND);
                    forgotPassword.setOnAction(event -> {
                    passwordChange(stage, index);
                    });
                    grid.add(forgotPassword, 1, 5);
                }
            }
        });
        grid.add(logIn, 0, 3);
        grid.add(loginMessage, 1, 4);
        
        Button back = new Button("you don't have an account?");
        back.setCursor(Cursor.HAND);
        back.setTextFill(Color.DARKCYAN);
        back.setFont(Font.font("Times new Roman", 16));
        back.setBackground(Background.EMPTY);
        back.setOnAction(e -> {
            try {
                regestrationPage(stage);
            } catch (Exception ex) {
                Logger.getLogger(Assignment1FX.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(back, 1, 3);
        
        
    }
    public void passwordChange(Stage stage, int index){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        
        Label title = createLabel("Password Change", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 22);
        title.setTextFill(Color.DARKCYAN);
        grid.add(title, 0, 0, 2, 1);
        
        final Text message = new Text();
        Label verificationQuestionLabel = createLabel("What is your mother's name?", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField verificationQuestionField = createTextField("your mother's name", 300);
        grid.add(verificationQuestionLabel, 0, 1);
        grid.add(verificationQuestionField, 1, 1);
        Button confirmChanges = createButton("Confirm", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        grid.add(confirmChanges, 1, 4);
        Label newPasswordLabel = createLabel("New Password", "Times new Roman", FontWeight.NORMAL,FontPosture.REGULAR, 16);
        TextField newPasswordField = createTextField("New password", 300);
        Label newPasswordConfirmLabel = createLabel("Confirm New Password", "Times new Roman", FontWeight.NORMAL,FontPosture.REGULAR, 16);
        TextField newPasswordConfirmField = createTextField("New password", 300);
        confirmChanges.setOnAction(e -> {
            if (verificationQuestionField.getText().isEmpty()) {
                message.setText("You must answer the question!");
                message.setFill(Color.RED);
            } else if (!newPasswordField.getText().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
                message.setText("Invalid password!");
                message.setFill(Color.RED);
            }else if(!newPasswordField.getText().equals(newPasswordConfirmField.getText())){
                message.setText("Passwords don't match");
                message.setFill(Color.RED);
            }else if (verificationQuestionField.getText().equals(users.get(index).getPasswordVerification())) {
                users.get(index).setPassword(newPasswordField.getText());
                message.setText("Password changed successfully!");
                message.setFill(Color.GREEN);
                loginPage(stage);
            } else {
                message.setText("Your answer is wrong");
                message.setFill(Color.RED);
            }
        });

        grid.add(newPasswordLabel, 0, 2);
        grid.add(newPasswordField, 1, 2);
        grid.add(newPasswordConfirmLabel, 0, 3);
        grid.add(newPasswordConfirmField, 1, 3);
        grid.add(message, 1, 5);
    }
    private int findUserIndex(List<User> users, String email) {
    int left = 0;
    int right = users.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        User user = users.get(mid);
        int cmp = email.compareTo(user.geteMail());

        if (cmp < 0) {
            right = mid - 1;
        } else if (cmp > 0) {
            left = mid + 1;
        } else {
            return mid;
        }
    }

    return -1;
    }

    public void startSystem(Stage stage, int index){
        //ordering the page
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, 800, 800);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        
        // left border: button choices: dashboard, transaction, payment, and logout.
        GridPane left = new GridPane();
        left.setPadding(new Insets(25, 25, 25, 25));
        left.setAlignment(Pos.CENTER);
        left.setHgap(10);
        left.setVgap(10);
        left.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID, new CornerRadii(5),new BorderWidths(3), new Insets(10, 10, 0, 0))));
        border.setLeft(left);
        
        Button newAccountButton = createButton("New Account", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(newAccountButton, 0, 0);
        
        Button services = createButton("Services", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(services, 0, 1);
        
        Button invest = createButton("Invest", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(invest, 0, 2);
        
        Button loans = createButton("Loans", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(loans, 0, 3);
        
        Button aboutUs = createButton("About Us", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(aboutUs, 0, 4);
        
        Separator seprator = new Separator();
        left.add(seprator, 0, 5);
        
        Button support = createButton("Support", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(support, 0, 6);
        
        Button logout = createButton("LogOut", "Times new Roman", 16, 100, 40, "darkCyan", "white", "white", "black");
        left.add(logout, 0, 7);
        
        //top bordr: title, personal information, and search bar.
        GridPane top = new GridPane();
        top.setPadding(new Insets(10, 10, 10, 10));
        top.setAlignment(Pos.BASELINE_LEFT);
        top.setHgap(10);
        top.setVgap(10);
        border.setTop(top);
        
        Circle iconCircle = new Circle();
        iconCircle.setFill(Color.DARKCYAN);
        iconCircle.setRadius(25);
        Button iconButton = new Button();
        iconButton.setCursor(Cursor.HAND);
        iconButton.setBackground(null);
        iconButton.setGraphic(iconCircle);
        iconButton.setAlignment(Pos.BASELINE_LEFT);
        top.add(iconButton, 0, 0);
        
        iconButton.setOnAction(e-> {
            personalInformation(stage, index);
        });
        Label nameLabel = createLabel(users.get(index).getFirstName() + " " + users.get(index).getLastName(), "Times new Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 22);
        top.add(nameLabel, 1, 0);
        Label accountNumberLabel = createLabel(accounts.get(index).getAccountNumber(), "Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 22);
        top.add(accountNumberLabel, 3, 0);
    }
    
    public void personalInformation(Stage stage, int index){
        GridPane grid = new GridPane();
        Scene personalInformation = new Scene(grid, 400, 400);
        personalInformation.setFill(Color.WHITE);
        stage.setScene(personalInformation);
        stage.setMaximized(true);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text title = new Text("Your informations");
        title.setFont(Font.font("Times new Roman", FontWeight.BOLD, 20));
        title.setFill(Color.DARKCYAN);
        grid.add(title, 1, 0, 2, 1);
        
        HBox nameBox = new HBox();
        nameBox.setSpacing(10);
        Label nameLabel = createLabel("Name", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField firstNameField = createTextField(null, users.get(index).getFirstName(), false, "Times new Roman", 16, 150);
        TextField lastNameField = createTextField(null, users.get(index).getLastName(), false, "Times new Roman", 16, 150);
        nameBox.getChildren().addAll(firstNameField, lastNameField);
        grid.add(nameLabel, 0, 1);
        grid.add(nameBox, 1, 1);
        
        Label idLabel = createLabel("ID", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField idField = createTextField(null, users.get(index).getId(), false, "Times new Roman", 16, 300);
        grid.add(idLabel, 0, 2);
        grid.add(idField, 1, 2);
        
        Label dateOfBirthLabel = createLabel("Date Of Birth", "Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        LocalDate dateOfBirthCheck = users.get(index).getDateOfBirth();
        String dateOfBirthString = (dateOfBirthCheck != null) ? dateOfBirthCheck.toString() : "";
        TextField datOfBirthField = createTextField(null, dateOfBirthString, false, "Times New Roman", 16, 300);

        grid.add(dateOfBirthLabel, 0, 3);
        grid.add(datOfBirthField, 1, 3);
        
        Label eMailLabel = createLabel("Email", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField eMailField = createTextField(null, users.get(index).geteMail(), false, "Times new Roman", 16, 300);
        grid.add(eMailLabel, 0, 4);
        grid.add(eMailField, 1, 4);
        
        Label phoneLabel = createLabel("phone", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField phoneField = createTextField(null, users.get(index).getPhone(), false, "Times new Roman", 16, 300);
        grid.add(phoneLabel, 0, 5);
        grid.add(phoneField, 1, 5);
        
        HBox firstLine = new HBox();
        firstLine.setSpacing(10);
        HBox secondLine = new HBox();
        secondLine.setSpacing(10);
        Label countryLabel = createLabel("Address", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField streetAddressField = createTextField(null, users.get(index).getAddress().getStreet(), false, "Times new Roman", 16, 150);
        TextField regionField = createTextField(null, users.get(index).getAddress().getState(), false, "Times new Roman", 16, 150);
        TextField postalField = createTextField(null, users.get(index).getAddress().getPostalCode(), false, "Times new Roman", 16, 150);
        TextField countryField = createTextField(null, users.get(index).getAddress().getCountry(), false, "Times new Roman", 16, 150);
        TextField cityField = createTextField(null,users.get(index).getAddress().getCity(), false, "Times new Roman", 16, 150);
        
        firstLine.getChildren().addAll(streetAddressField, regionField);
        secondLine.getChildren().addAll(postalField, countryField);
        grid.add(countryLabel, 0, 6);
        grid.add(firstLine, 1, 6);
        grid.add(secondLine, 1, 8);
        grid.add(cityField, 1, 7);
        
        Label genderLabel = createLabel("Gender", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField genderField = createTextField(null, users.get(index).getGender(), false, "Times new Roman", 16, 300);
        grid.add(genderLabel, 0, 9);
        grid.add(genderField, 1, 9);
        
        Label languageLabel = createLabel("Languages", "Times new Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        TextField languageField;
        languageField = createTextField(null, Arrays.toString(users.get(index).getLanguage()), false, "Times new Roman", 16, 300);
        grid.add(languageLabel, 0, 10);
        grid.add(languageField, 1, 10);
               
        Button back = new Button("Back to main page?");                         
        back.setCursor(Cursor.HAND);
        back.setTextFill(Color.DARKCYAN);
        back.setFont(Font.font("Times new Roman", 16));
        back.setBackground(Background.EMPTY);
        back.setOnAction(e -> {
            startSystem(stage, index);
        });
        grid.add(back, 1, 11);
    }
    
    private Button createButton(String text, String font, double fontSize, double buttonHeight, double buttonWidth, String fillColor, String cursorOn, String fontCursorOff, String fontCursorOn) {
        Button button = new Button(text);
        button.setMinSize(buttonHeight, buttonWidth);
        button.setFont(Font.font(font, fontSize));
        button.setCursor(Cursor.HAND);
        button.setStyle("-fx-background-color: " + fillColor + "; -fx-border-color: black; -fx-text-fill: " + fontCursorOff + "; -fx-background-radius: 10; -fx-border-radius: 10;");
        // Set button hover effect
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color:" + cursorOn + "; -fx-text-fill: " + fontCursorOn + "; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + fillColor + "; -fx-text-fill: " + fontCursorOff + "; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10;"));
        return button;
    }
    
    public static Label createLabel(String text, String fontName, FontWeight fontWeight, FontPosture fontPosture, double fontSize) {
        Label label = new Label(text);
        Font font = Font.font(fontName, fontWeight, fontPosture, fontSize);
        label.setFont(font);
        return label;
    }
    
    public static TextField createTextField(String promptText, double widthSize) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setMaxWidth(widthSize);
        return textField;
    }
    
    public static TextField createTextField(String promptText, String text, boolean editable, String font, double fontSize, double widthSize) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setMaxWidth(widthSize);
        textField.setText(text);
        textField.setEditable(editable);
        textField.setFont(Font.font(font, fontSize));
        return textField;
    }
}
