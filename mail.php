<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <title>Envoi mail</title>



</head>


<body>

    <?php
    $to = 'audreyheurtauxsene@gmail.com';
    $subject = $_POST["objet"];
    $message = $_POST["message"];
    $headers = 'From:' . trim($_POST["email"]) . "\n";
    mail($to, $subject, $message, $headers);
    ?>

    <p> Votre message a bien été envoyé, merci . </p>



</body>

</html>