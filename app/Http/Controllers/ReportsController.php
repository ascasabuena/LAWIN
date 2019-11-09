<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

//use Illuminate\Support\Facades\Input;
use App\Devices;
use App\DeviceMaster;
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

    public function setCoordinates($phone_no, $lat, $lng) {
    	//get device id based from phone no
        $DeviceMaster = DeviceMaster::where('phone_no', $phone_no)->first();

        if(!$DeviceMaster){
            return response()->json([
                'message' => "invalid phone number"
            ]);
        }

    	//get user id based from phone no
        $Devices = Devices::where('phone_no', $DeviceMaster->id)->first();

    	$reports = new Reports;
    	$reports->lat = $lat;
    	$reports->lng = $lng;

    	$reports->devices_id = $Devices->id;
    	$reports->devices_users_id = $Devices->users_id;

    	$reports->save();

    	return response()->json([
    		'message' => "save success"
    	]);



    }
}
