//
//  JobDetailsView.swift
//  KMM_Showcase
//
//  Created by Edgars Simanovskis on 22/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct JobDetailsView: View {
    var jobDetails = "Job Detail"
    
    var body: some View {
        VStack() {
            JobInfoView()
            BottomView()
        }
        .background(Color.offWhite.ignoresSafeArea())
        .ignoresSafeArea()
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: BackButton(text: jobDetails))
        
    }
}

struct JobInfoView: View {
    var price = "80-95 Baht"
    var date = "25 Mar 2022"
    var time = "6:00-12:00"
    var distance = "33 km"
    var area = "70 m2"
    var address = "123 NimbleHq"
    var cropType = "Corn"
    var message = "Message to pilot"
    
    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            Spacer(minLength: 90)
            VStack(alignment: .leading) {
                HStack {
                    Text("Price by area")
                        .font(.subheadline)
                        .foregroundColor(Color.greyColor)
                    Spacer()
                    Text(price)
                        .font(.headline)
                        .fontWeight(.bold)
                        .foregroundColor(.greenColor)
                }
                .padding(.bottom)
                
                
                Text("Date time")
                    .font(.headline)
                    .bold()
                
                VStack {
                    HStack {
                        Text(date)
                            .font(.headline)
                            .bold()
                        Spacer()
                        Text(time)
                            .font(.footnote)
                            .foregroundColor(Color.greyColor)
                    }
                    .frame(maxWidth: .infinity)
                }
                .padding()
                .background(RoundedRectangle(cornerRadius: 20)
                                .fill(Color.white)
                )
                .compositingGroup()
                .shadow(color: Color.greyColor, radius: 1, x: 0, y: 0.8)
                
                
                Text("Plot Information")
                    .font(.headline)
                    .bold()
                    .padding(.top)
                VStack(alignment: .leading) {
                    HStack(spacing: 100) {
                        VStack(spacing: 10) {
                            Text("Distance")
                                .font(.body)
                                .foregroundColor(Color.greyColor)
                            Text(distance)
                                .font(.body)
                                .foregroundColor(.greenColor)
                        }
                        VStack(spacing: 10) {
                            Text("Area")
                                .foregroundColor(Color.greyColor)
                            Text(area)
                                .foregroundColor(.greenColor)
                        }
                    }
                    .frame(maxWidth: .infinity)
                    .padding(.bottom)
                    
                    VStack(alignment: .leading, spacing: 6) {
                        Text("Address")
                            .font(.subheadline)
                            .foregroundColor(Color.greyColor)
                        Text(address)
                            .font(.subheadline)
                            .padding(.bottom, 4)
                        
                        Text("Crop type")
                            .font(.subheadline)
                            .foregroundColor(Color.greyColor)
                        Text(cropType)
                            .font(.subheadline)
                    }
                }
                .padding()
                .background(RoundedRectangle(cornerRadius: 30)
                                .fill(Color.white)
                )
                .compositingGroup()
                .shadow(color: Color.greyColor, radius: 1, x: 0, y: 1)
                
                Text("Message to pilot")
                    .bold()
                    .padding(.vertical, 4)
                Text(message)
                    .font(.subheadline)
                
                Spacer()
            }
            .padding()
            .frame(maxWidth: .infinity)
        }
    }
}

struct BottomView: View {
    var description = "Get this job to know more about farmer contact information"
    var price = "80-95 Baht"
    var body: some View {
        VStack(alignment: .leading) {
            Text(description)
                .fontWeight(.semibold)
                .padding(.vertical)
            HStack {
                Text("Price")
                    .fontWeight(.light)
                Spacer()
                Text(price)
                    .font(.title3)
                    .fontWeight(.bold)
                    .foregroundColor(.greenColor)
            }
            Button("Accept", action: {})
                .buttonStyle(FatGreenButton())
                .padding(.bottom, 10)
        }
        .padding()
        .background(Color.white)
        .cornerRadius(40)
        .overlay(
            RoundedRectangle(cornerRadius: 40)
                .stroke(Color.gray.opacity(0.2), lineWidth: 1)
        )
    }
}

struct JobDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        JobDetailsView()
    }
}
