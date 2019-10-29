<?php

namespace App\Http\Controllers;


use Illuminate\Http\Request;

use Illuminate\Support\Facades\Hash;
use App\Users;

use PHPMailer\PHPMailer;

class UsersController extends Controller
{
    public function setUser(Request $request){
    	$fname = $request->input('fname');
    	$mname = $request->input('mname');
    	$lname = $request->input('lname');
    	$bdate = $request->input('bdate');
    	$gender = $request->input('gender');
    	$address = $request->input('address');
    	$phone_no = $request->input('phone_no');
    	$emergency_no = $request->input('emergency_no');
    	$email = $request->input('email');
    	$username = $request->input('username');

    	
    	$password = $request->input('password');
    	$type = $request->input('type');
    	$status = $request->input('status');

    	//checks if a user exists based on username or email
    	$users = Users::where('username', $username)->orwhere('email',$email)->first();

//if user not exist, register it.
    	if(!$users){	
	    	$users = Users::create ([
	    		'fname' => $fname,
		    	'mname' => $mname,
		    	'lname' => $lname,
		    	'bdate' => $bdate,
		    	'gender' => $gender,
		    	'address' => $address,
		    	'phone_no' => $phone_no,
		    	'emergency_no' => $emergency_no,
		    	'email' => $email,
		    	'username' => $username,
		    	'password' => Hash::make($password),
		    	//0 = user
		    	//1 = policel
				'type' => $type,
				'status' => $status,
	    	]);

			  $mail = new PHPMailer\PHPMailer(true);

		try {
		    //Server settings
		    $mail->SMTPDebug = 0;                      // Enable verbose debug output
		    $mail->isSMTP();                                            // Send using SMTP
		    $mail->Host       = 'smtp.gmail.com';                    // Set the SMTP server to send through
		    $mail->SMTPAuth   = true;                                   // Enable SMTP authentication
		    $mail->Username   = 'lawin.apc@gmail.com';                     // SMTP username
		    $mail->Password   = 'be@rammm';                               // SMTP password
		    $mail->SMTPSecure = 'ssl';         // Enable TLS encryption; `PHPMailer::ENCRYPTION_SMTPS` also accepted
		    $mail->Port       = 465;                                    // TCP port to connect to

		    //Recipients
		    $mail->setFrom('lawin.apc@gmail.com', 'LAWIN No-Reply');
		    $mail->addAddress($email,$fname.' '.$lname);     // Add a recipient
		   
		    // Content
		    $mail->isHTML(true);                                  // Set email format to HTML
		    $mail->Subject = 'Lawin registration';
		    $mail->Body    = 'Please confirm your email....';

		    $mail->send();
		    
		} catch (Exception $e) {
		    return response()->json([
		    'message' => $mail->ErrorInfo
		    ]);
		}

    	return response()->json($users);
    	
		}else{

		return response()->json([
			'message' => 'Error account already exists.'

		]);

    	}
   
    }

    public function verifyUser($username){

    	
    	$user = Users::where('username',$username)->first();

    	if($user){
    	$user ->status = "activated";
    	$user->save();
    	return response()->json([
    		'message' => 'account activated'

    	]);
    }else {
    	return response()->json([
    		'message' => 'Invalid user account.'

    	]);
    }

   }
}

