<?php
    if(isset($_POST['submit'])){
        $file = $_FILES['file'];
        $fileName = $_FILES['file']['name'];
        $fileTempName = $_FILES['file']['tmp_name'];
        $fileSize = $_FILES['file']['size'];
        $fileError = $_FILES['file']['error'];
        $fileType = $_FILES['file']['type'];

        $fileExt = explode('.',$fileName);
        $fileActualExt = strtolower(end($fileExt));

        $allowed = array('jpg','jpeg','png');
        if(in_array($fileActualExt, $allowed)){
            if($fileError === 0) {
                if($fileSize<1000000){
                    $fileNameNew = uniqid('',true).".".$fileActualExt;
                    $fileDestination = 'uploads/'.$fileNameNew;
                    move_uploaded_file($fileTempName,$fileDestination);
                    header("Location: index.php?uploadsuccess");
                } else{
                    echo "file size to big!";
                }
            } else{
                echo "There was an error uploading your file!";
            }
        } else{
            echo "You cannot upload files!";
        }
    }
?>