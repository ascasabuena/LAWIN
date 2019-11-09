<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

//use Illuminate\Support\Facades\Input;
use App\Devices;
use App\Reports;
use App\Users;

class ReportsController extends Controller
{

    public function getCoordinates($id){

        $reports = Reports::where('devices_id', $id)
        ->orderBy('date_created','desc')
        ->first();

        return response()->json($reports);


    }

    public function setCoordinates(Request $request) {
    	$phoneNo = $request->input('phoneNo'); 
    	$lat = $request->input('lat');
    	$lng = $request->input('lng');

    	//get device id based from phone no
        $devices = Devices::where('phone_no',$phoneNo)->first();

        if(!$devices){

        return response()->json([
            'message' => "invalid phone number"
        ]);
        }

    	//get user id based from phone no
        $users = Devices::where('id',$devices->users_id)->first();

    	$reports = new Reports;
    	$reports->lat = $lat;
    	$reports->lng = $lng;

    	$reports->devices_id = $devices->id;
    	$reports->devices_users_id = $users->id;
    	

    	$reports->save();

    	return response()->json([
    		'message' => "save success"
    	]);



    }
}
