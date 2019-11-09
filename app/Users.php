<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Users extends Model
{
    protected $table = 'users';
    public $timestamps = false;
    protected $fillable = array(

    	'fname',
    	'mname',
    	'lname',
    	'bdate',
    	'gender',
    	'address',
    	'phone_no',
    	'emergency_no',
    	'email',
    	'username',
    	'password',
    	'type',
    	'status'
    	


    );
}
